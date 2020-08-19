package everyday;
/**
 * middle 50
 * 1、自己的想法
 * 快速幂，没啥其他好说的。
 * */
public class Pow {
    public double myPow(double x, int n){
        if(n==0)return 1;
        boolean reverse = false;
        long times = 0;
        if(n<0){
            times = n;
            times = -times;
            reverse = true;
        }
        double ans = 1.0;
        while(times>0){
            if((times&1)==1){
                ans = ans*x;
            }
            x = x*x;
            times = times>>1;
        }
        if(reverse) ans = 1.0/ans;
        return ans;
    }

    public static void main(String[] args) {
        Pow test = new Pow();
        test.myPow(-13.62608,3);
    }
}
