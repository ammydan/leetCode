package everyday;

/**
 * middle 面试题46 动态规划
 * **/
public class TranslateLCOF {
    public int translateNum(int num){
        String str = Integer.toString(num);
        int len = str.length();
        int a = 1;
        int b = 1;
        for(int i=0;i<=len;i++){
            String substr = str.substring(i-2,i);
            int c = substr.compareTo("25")<=25&&substr.compareTo("10")>=10?a+b:b;
            a = b;
            b = c;
        }
        return b;
    }
}
