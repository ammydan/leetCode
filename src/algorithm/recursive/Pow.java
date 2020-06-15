package algorithm.recursive;

public class Pow {
    public double myPow(double x, int n){
        double ans = 1.0;
        boolean flag = false;
        long back = 1;
        back = n;
        if(n<0){
            flag=true;
            back = -back;

        }
        while(back>0){
            if((back&1)>0){
                ans = ans*x;
            }
            x = x*x;
            back = back>>1;
        }
        if(flag)ans = 1.0/ans;
        return ans;
    }

    public static void main(String[] args) {
//        Pow test = new Pow();
//        test.myPow(2.00000, -2147483648);
        long n = Integer.MIN_VALUE;
        System.out.println(-n);
    }

}
