package everyday;

import java.util.LinkedList;
/**
 * hard 97
 * 1、自己的想法
 * 一开始肯定是想要双指针，但是发现s1和s2某个元素相等都能和s3的元素匹配时，就需要做选择。
 * 然后我加了stack进行回溯，发现最终还是超时了。
 * 2、参考思路
 * opt[i][j]代表s1从0到i以及s2从0到j可以和s3从0到i+j匹配。有三情况第一种时和s1匹配，第二种是和s2匹配，最后是false;
 * */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3){
//        1、回溯
//        int len1 = s1.length();
//        int len2 = s2.length();
//        int len3 = s3.length();
//        LinkedList<int[]> stack = new LinkedList<>();
//        int index1 = 0, index2 = 0, index3 = 0;
//        while(index3<len3||!stack.isEmpty()){
//            if(index3==len3)return true;
//            if(index1>=len1){
//                if(s2.charAt(index2)==s3.charAt(index3)){
//                    index2++;
//                    index3++;
//                }else {
//                    if(stack.isEmpty())return false;
//                    int[] temp = stack.pop();
//                    index1 = temp[0];
//                    index2 = temp[1];
//                    index3 = temp[2];
//                }
//            }else if(index2>=len2){
//                if(s1.charAt(index1)==s3.charAt(index3)){
//                    index1++;
//                    index3++;
//                }else{
//                    if(stack.isEmpty())return false;
//                    int[] temp = stack.pop();
//                    index1 = temp[0];
//                    index2 = temp[1];
//                    index3 = temp[2];
//
//                }
//            }else if(s1.charAt(index1)==s3.charAt(index3)||s2.charAt(index2)==s3.charAt(index3)){
//                if(s1.charAt(index1)==s2.charAt(index2)){
//                    int[] temp = new int[3];
//                    temp[0] = index1;
//                    temp[1] = index2+1;
//                    temp[2] = index3+1;
//                    stack.push(temp);
//                    index1++;
//                    index3++;
//                }else if(s1.charAt(index1)==s3.charAt(index3)){
//                    index1++;
//                    index3++;
//                }else {
//                    index2++;
//                    index3++;
//                }
//            }else{
//                if(stack.isEmpty())return false;
//                int[] temp = stack.pop();
//                index1 = temp[0];
//                index2 = temp[1];
//                index3 = temp[2];
//            }
//        }
//        return true;
//        2、参考思路：动态规划
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if(len1+len2!=len3)return false;
        boolean[][] opt = new boolean[len1+1][len2+1];
        opt[0][0] = true;
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                int k = i+j-1;
                if(i>0){
                    opt[i][j] = (opt[i-1][j]&&s1.charAt(i-1)==s3.charAt(k))||opt[i][j];
                }
                if(j>0){
                    opt[i][j] = (opt[i][j-1]&&s2.charAt(j-1)==s3.charAt(k))||opt[i][j];
                }
            }
        }
        return opt[len1][len2];
    }

    public static void main(String[] args) {
        InterleavingString test = new InterleavingString();
        test.isInterleave("aabcc","dbbca","aadbbcbcac");
    }
}
