package everyday;

/**
 * hard 10
 * 1、自己的想法
 * 自己的第一个想法就是模拟替换符号的功能，但是最后发现只靠四个指针是不行的，因为c*可能出现0次。
 *
 * 2、参考的想法
 * ①动态规划
 * opt[i][j]代表着原来的字符串s前i个字符和模式p的前j个字符相匹配。
 * 如果s[i]==p[j]
 * opt[i][j] = opt[i-1][j-1]
 * 否则，如果p[j]=='*'那么我们进一步细分，因为*可以控制前面一个符号出现的次数那么我们就按照次数来讲:
 *  如果p[j-1]!=s[i]那么我们就要求出现0次，opt[i][j-2]
 *  如果p[j-1]==s[i]那么就可能要求出现1次或者多次，但是多次和1次也可以转换成0次，因为opt是记录了整个过程，总有一次是出现在恰好不相等的部分。
 *  所以opt[i][j] = opt[i-1][j]
 * **/
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p){
//        int sIndex = 0;
//        int pIndex = 0, pre = -1, post = -1;
//        int lenS = s.length(), lenP = p.length();
//        while(sIndex<lenS||pIndex<lenP){
//            if(sIndex>=lenS&&pIndex!=lenP-1)return false;
//            if(pIndex>=lenP)return false;
//            if(sIndex>=lenS&&pIndex==lenP-1){
//                if(p.charAt(pIndex)!='*')return false;
//                break;
//            }
//            char tempS = s.charAt(sIndex);
//            char tempP = p.charAt(pIndex);
//            if(tempP==tempS||tempP=='.'){
//                pIndex++;
//                sIndex++;
//                continue;
//            }
//            if(tempP!='*'&&pIndex+1<lenP&&p.charAt(pIndex+1)=='*'){
//                pIndex+=2;
//                continue;
//            }
//
//            if(pre!=-1&&(p.charAt(pre)==tempS||p.charAt(pre)=='.')){
//                sIndex++;
//            }else if(post!=-1&&p.charAt(post)==tempS){
//                pIndex = post+1;
//                post = -1;
//                pre = -1;
//                sIndex++;
//            }else if(post!=-1&&p.charAt(post)=='.'){
//                pIndex = post;
//                pre=-1;
//                post = -1;
//            }else return false;
//
//        }
//        return true;
        boolean[][] opt = new boolean[s.length()+1][p.length()];
        opt[0][0] = true;
        for(int i=2;i<=p.length();i++){
            opt[0][i] = opt[0][i-2]&&p.charAt(i-1)=='*';
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                int m = i-1;
                int n = j-1;
                if(p.charAt(n)==s.charAt(m)||p.charAt(n)=='.')opt[i][j] = opt[i-1][j-1];
                else if(p.charAt(n)=='*'){
                    opt[i][j] = opt[i][j-2]||opt[i-1][j] &&
                            (s.charAt(m) == p.charAt(n - 1) || p.charAt(n - 1) == '.');
                }
            }
        }
        return opt[s.length()][p.length()];
    }

    public static void main(String[] args) {
        RegularExpressionMatching test = new RegularExpressionMatching();
        System.out.println(test.isMatch("mississippi",
                "mis*is*ip*."));
//        test.isMatch("aaa","a*a");
    }
}
