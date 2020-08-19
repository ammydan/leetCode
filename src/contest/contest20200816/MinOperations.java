package contest.contest20200816;

public class MinOperations {
    public int minOperateions(int n){
        if(n==1)return 0;
        if(n%2==0){
            int num = n/2;
            int avg = (2*(n-1)+1+1)/2;
            int max = (avg-1);
            int ans = (1+max)/2*num;
            return ans;
        }else{
            int num = (n-1)/2;
            int avg = (2*(n-1)+1+1)/2;
            int max = (avg-1);
            int ans = (2+max)/2*num;
            return ans;
        }
    }

    public static void main(String[] args) {
        MinOperations test = new MinOperations();
        test.minOperateions(3);
    }
}
