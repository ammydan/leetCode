package everyday;

public class ValidPalindrome {
    public boolean isPalindrome(String s){
        s = s.toLowerCase();
        int left = 0,right = s.length()-1;
        while(left<right){
            while(left<right&&(s.charAt(left)>'z'||s.charAt(left)<'a'))left++;
            while(left<right&&(s.charAt(right)>'z'||s.charAt(right)<'a'))right--;
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome test = new ValidPalindrome();
        test.isPalindrome("OP");
    }
}
