package algorithm.subString;

import java.util.Arrays;
/**
 * 时间复杂度：随机~N/M 最差O(N*M)
 * 空间复杂度：O(R)
 * */
public class BoyerMoore {
    private int[] right;
    private String pattern;
    private final int nums=26;
    public BoyerMoore(String pattern){
        this.pattern = pattern;
        right = new int[nums];
        getRightMost();
    }
    private void getRightMost(){
        Arrays.fill(right,-1);
        int len = pattern.length();
        for(int i=0;i<len;i++){
            right[pattern.charAt(i)-'a'] = i;
        }
    }
    public int search(String str){
        int skip=0;
        int lenS = str.length();
        int lenP = pattern.length();
        for(int i=0;i<=lenS-lenP;i+=skip){
            skip=0;
            for(int j=lenP-1;j>=0;j--){
                if(pattern.charAt(j)!=str.charAt(i+j)){
                    skip = Math.max(1, right[pattern.charAt(j)]);
                    break;
                }
            }
            if(skip==0)return i;
        }

        return -1;
    }

}
