public class Practice {
    public int getLongestPalindrome(String A, int n) {
        int max = 1;
        boolean[][] opt = new boolean[n][n];
        for(int i = 0;i<n;i++){
            opt[i][i] = true;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(A.charAt(i)==A.charAt(j)){
                    if(i-j<2){
                        opt[j][i] = true;
                        System.out.println(i+" "+j);
                        max = max>i-j+1?max:i-j+1;
                    }
                    else {
                        opt[j][i] = opt[j+1][i-1];
                        if(opt[j][i]) max = max>i-j+1?max:i-j+1;
                    }
                }else{
                    opt[j][i] =false;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Practice test = new Practice();
        test.getLongestPalindrome("ccbcabaabba",11);

    }
}
