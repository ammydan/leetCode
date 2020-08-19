package everyday;

public class MaximumLengthofRepeatedSubarray {
    public int findLength(int[] A, int[] B){
//        1、自己的想法
//        int lenA = A.length;
//        int lenB = B.length;
//        if(lenA==0||lenB==0)return 0;
//        int indexA,indexB,max=0;
//        for(int i=0;i<lenA;i++){
//            for(int j=0;j<lenB;j++){
//                indexA = i;
//                indexB = j;
//                int temp = 0;
//                while(indexA<lenA&&indexB<lenB){
//                    if(A[indexA++]==B[indexB++])temp++;
//                    else break;
//                }
//                if(temp>max) max = temp;
//            }
//        }
//        return max;
//        2、参考方法①：动态规划
//        int lenA = A.length;
//        int lenB = B.length;
//        if(lenA==0||lenB==0)return 0;
//        int [][] opt = new int[lenA+1][lenB+1];
//        int max=0;
//        for(int i=lenA-1;i>=0;i--){
//            for(int j=lenB-1;j>=0;j--){
//                opt[i][j] = A[i]==B[j]?opt[i][j]+1:0;
//                max = Math.max(max,opt[i][j]);
//            }
//        }
//        return max;
//        2、参考方法②：滑动窗口
        int lenA = A.length;
        int lenB = B.length;
        int max = 0;
        if(lenA==0||lenB==0)return 0;
        for(int i=0;i<lenA;i++){
            int len = Math.min(lenA-i,lenB);
            int temp = 0;
            for(int j=0;j<len;j++){
                if(A[i+j]==B[j]){
                    temp++;
                    if(temp>max) max = temp;
                }
                else{
                    temp=0;
                }
            }
        }
        for(int i=0;i<lenB;i++){
            int len = Math.min(lenB-i,lenA);
            int temp = 0;
            for(int j=0;j<len;j++){
                if(A[j]==B[i+j]){
                    temp++;
                    if(temp>max) max = temp;
                }
                else{
                    temp=0;
                }
            }
        }
        return max;

    }
    public static void main(String[] args)
    { MaximumLengthofRepeatedSubarray test = new MaximumLengthofRepeatedSubarray();
        int[] A = {1,2,3,2,1};
//        int[] A = {0,0,0,0,1};
        int[] B = {3,2,1,4,7};
//        int[] B = {1,0,0,0,0};
        test.findLength(A,B);
    }
}
