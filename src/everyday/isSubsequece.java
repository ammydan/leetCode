package everyday;
/**
 * easy 392
 * */
public class isSubsequece {
    public boolean isSubsequence(String s, String t){
        int lenT = t.length();
        int lenS = s.length();
        if(lenS==0)return true;
        if(lenT==0)return false;
        int index = 0;
        for(int i=0;i<lenT;i++){
            if(s.charAt(index)==t.charAt(i)){
                if(index==lenS-1)return true;
                index++;
            }
        }
        return false;
    }
}
