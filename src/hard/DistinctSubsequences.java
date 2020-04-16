package hard;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
            int slen = s.length();
            int tlen = t.length();
            int [][]memo = new int[tlen+1][slen+1];
            for(int i=0;i<=tlen;i++){
                for(int j=0;j<=slen;j++){
                    if(i==0){
                        memo[i][j]=1;
                        continue;
                    } else if(j==0){
                        memo[i][j]=0;
                    }
                    if(t.charAt(i-1)==s.charAt(j-1)){
                        memo[i][j] = memo[i-1][j-1]+memo[i][j-1];
                    }else{
                        memo[i][j] = memo[i][j-1];
                    }
                }
            }
            return memo[tlen][slen];
    }

    public static void main(String[] args) {
        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        String s = "rabbbit";
        String t = "rabbit";
        distinctSubsequences.numDistinct(s,t);
    }
}
