package algorithm.Dp;

import java.util.Arrays;
/**
 * 72 hard
 * 快速查看重叠子问题：通过各个转移状态的不同选择进行判断
 * */
public class EditDistance {
//    private int len1,len2;
//    private String word1, word2;
//    public int minDistance(String word1, String word2){
//        this.len1 = word1.length();
//        this.len2 = word2.length();
//        this.word1 = word1;
//        this.word2 = word2;
//        return helper(0,0,0);
//    }
//    private int helper(int n, int m, int sum){
//
//        int min = Integer.MAX_VALUE;
//        if(word2.charAt(n)==word1.charAt(m))min = Math.min(min,helper(n+1,m+1,sum));
//        else{
//            min = Math.min(min,helper(n+1,m,sum+1));
//            min = Math.min(min,helper(n,m+1,sum+1));
//            min = Math.min(min,helper(n+1,m+1,sum+1));
//        }
//        return min;
//    }
    private int len1,len2;
    private String word1, word2;
    private int [][] opt;
    public int minDistance(String word1, String word2){
        this.len1 = word1.length();
        this.len2 = word2.length();
        this.word1 = word1;
        this.word2 = word2;
        opt = new int[len2+1][len1+1];
        for(int i = 0;i<=len2;i++){
            Arrays.fill(opt[i],-1);
            opt[i][0] = i;
        }
        for(int i=0;i<=len1;i++){
            opt[0][i] = i;
        }
        for(int i=1;i<=len2;i++){
            for(int j=1;j<=len1;j++){
                if(word1.charAt(j-1)==word2.charAt(i-1))opt[i][j] = opt[i-1][j-1];
                else{
                    opt[i][j] = Math.min(opt[i-1][j]+1,opt[i][j-1]+1);
                    opt[i][j] = Math.min(opt[i][j],opt[i-1][j-1]+1);
                }
            }
        }
        return opt[len2][len1];
//        return helper(len2,len1);
    }
//    private int helper(int n, int m){
//        if(opt[n][m]!=-1)return opt[n][m];
//        int min = Integer.MAX_VALUE;
//        if(word2.charAt(n-1)==word1.charAt(m-1))min = Math.min(min,helper(n-1,m-1));
//        else{
//            min = Math.min(min,helper(n-1,m)+1);
//            min = Math.min(min,helper(n,m-1)+1);
//            min = Math.min(min,helper(n-1,m-1)+1);
//        }
//        opt[n][m] = min;
//        return min;
//    }

    public static void main(String[] args) {
        EditDistance test = new EditDistance();
        test.minDistance("horse","ros");
    }
}
