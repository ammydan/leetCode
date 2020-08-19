package algorithm.prime;

public class UglyNumber {
    public boolean isUgly(int num){
        if(num<2)return false;
        return helper(num);
    }
    public boolean helper(int n){
        if(n==1)return true;
        if(n%2==0)return helper(n/2);
        else if(n%3==0)return helper(n/3);
        else if(n%5==0)return helper(n/5);
        else return false;
    }
}
