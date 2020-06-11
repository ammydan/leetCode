package everyday;

public class PalindromeNumber {
    public boolean isPalindrome(int x){
//        方法一：直接转换成String类型方便比较
//        String str = Integer.toString(x);
//        int len = str.length();
//        for(int i=0;i<len;i++){
//            if(str.charAt(i)!=str.charAt(len-i-1))return false;
//        }
//        return true;

//        方法二：int反转
        int origin = x;
        int inverse = 0;
        while(x>0){
            int tmp = x%10;
            inverse = inverse*10+tmp;
            x/=10;
        }
        if(inverse==origin)return true;
        return false;
    }
}