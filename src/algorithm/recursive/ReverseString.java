package algorithm.recursive;

/**
 * 344 easy
 * **/
public class ReverseString {
    public void reverseString(char[] s) {
        if(s==null||s.length==0||s.length==1)return;
        helper(0,s);

    }
    private void helper(int index, char[]s){
        int len = s.length;
        if(index+1>len/2)return;
        char tmp = s[index];
        s[index] = s[len-1-index];
        s[len-1-index] = tmp;
        helper(index+1,s);
    }
}
