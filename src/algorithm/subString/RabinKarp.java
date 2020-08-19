package algorithm.subString;

public class RabinKarp {
    private final int R = 26;
    private long RM;
    private final long Prime = 997;
    private final String pattern;
    private long patternValue;
    public RabinKarp(String pattern){
        this.pattern = pattern;
    }
    private void hash(){
        int len  = pattern.length();
        RM = 1;
        patternValue = 0;
        for(int i=0;i<len;i++){
            patternValue+=(R*patternValue+pattern.charAt(i)-'a')%Prime;
        }
        for(int i=0;i<len-1;i++){
            RM = (RM*R)%Prime;
        }
    }
    public int search(String str){
        int lenS = str.length();
        int lenP = str.length();
        if(lenS<lenP)return -1;
        long strHash = 0;
        for(int i=0;i<lenP;i++){
            strHash+=(str.charAt(i)-'a'+strHash*R)%Prime;
        }
        if(strHash==patternValue)return 0;
        for(int i =lenP;i<lenS;i++){
            strHash = (strHash-(str.charAt(i-lenP)-'a')*RM)*R%Prime+str.charAt(i)-'a';
            if(strHash==patternValue)return i-lenP+1;
        }
        return -1;
    }
}
