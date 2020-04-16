package middle;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(divisor==0) throw new ArithmeticException();
        boolean flag = true;
        if((dividend>0)!=(divisor>0))flag=false;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if(divisor==1){
            if(flag) return dividend;
            return -dividend;
        }
        int sum = divisor;
        int i=1;
        while(sum<dividend){
            sum +=sum;
            i+=i;
        }
        if(sum==dividend) {
            if(flag) return sum;
            return -sum;
        }
        while(sum>dividend){
            sum -=divisor;
            i--;
        }
        if(flag) return sum;
        return -sum;

    }
}
