package contest.contest20200628;

public class CanArrange {
    public boolean canArrange(int[] arr,int k){
        int[] checkPositive = new int[k];
        int[] checkNegtive = new int[k];
        for(int i: arr){
            if(i>=0)checkPositive[i%k]++;
            else checkNegtive[Math.abs(i%k)]++;
        }
        if((checkPositive[0]+checkNegtive[0])%2!=0)return false;
        if(k%2==0&&(checkPositive[k/2]+checkNegtive[k/2])%2!=0)return false;
        for(int i=1;i<=k/2;i++){
           int num1P = checkPositive[i];
            int num2P = checkPositive[k-i];
            int num1N = checkNegtive[i];
            int num2N = checkNegtive[k-i];
            if(num1P>num2P){
                checkPositive[i] = num1P-num2P;
                checkPositive[k-i] = 0;
            }else{
                checkPositive[i] = 0;
                checkPositive[k-i] = num2P-num1P;
            }
            if(num1N>num2N){
                checkNegtive[i] = num1N-num2N;
                checkNegtive[k-i] = 0;
            }else{
                checkNegtive[i] = 0;
                checkNegtive[k-i] = num2N-num1N;
            }
            if(checkNegtive[i]!=0&&checkPositive[i]!=0){
                checkPositive[i] = Math.abs(checkNegtive[i]-checkPositive[i]);
            }
            if(checkPositive[k-i]!=0&&checkNegtive[k-i]!=0){
                checkPositive[k-i] = Math.abs(checkNegtive[k-i]-checkPositive[k-i]);
            }
        }
        for(int i=1;i<k;i++){
            if(checkPositive[i]!=0){
                if(k%i!=0)return false;
                else{
                    int factor = k/i;
                    if(checkPositive[i]%factor!=0)return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,10,6,7,8,9};
//        int[] arr = {1,2,3,4,5,6};
        int[] arr = {-10,5,0,-5,7,-5,7,9,5,-2,10,7,-6,-3,4,-6,10,-1,-6,14,0,6,-4,4,-2,-4,5,4,0,-8,-6,10,-8,-4,14,10,7,7,6,-1,-10,-8,22,9,10,8,-2,8,-10,3,18,1,11,8,7,-4,2,-10,0,-8,16,13,-9,7,17,1,1,-5,10,5,0,0,-5,-7,4,0,6,14,-8,13,5,4,1,5,10,4,9,2,6,8};

        CanArrange test = new CanArrange();
        test.canArrange(arr,14);
    }
}
