package everyday;

import java.util.Arrays;
import java.util.LinkedList;

public class WildcardMatching {
    public boolean isMatch(String s,String p){
        int lenS = s.length(), lenP = p.length();
        if(lenS>0&&lenP==0)return false;
        boolean [][] opt = new boolean[lenS+1][lenP+1];
        opt[0][0]  = true;
        for (int i = 1; i <= lenP; ++i) {
            if (p.charAt(i - 1) == '*') {
                opt[0][i] = true;
            } else {
                break;
            }
        }
        for(int i=1;i<=lenS;i++){
            for(int j=1;j<=lenP;j++){
                switch (p.charAt(j-1)){
                    case '?':
                        opt[i][j] = opt[i-1][j-1];
                        break;
                    case '*':
                        opt[i][j] = opt[i-1][j]||opt[i-1][j];
                        break;
                    default:
                        boolean flag = s.charAt(i-1)==p.charAt(j-1)?true:false;
                        opt[i][j] = opt[i-1][j-1]&&flag;
                }
            }
        }
        return opt[lenS][lenP];
    }

    public static void main(String[] args) {
        WildcardMatching test = new WildcardMatching();
        test.isMatch("zacabz", "*a?b*");
    }
}
