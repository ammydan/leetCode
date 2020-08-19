package everyday;

public class BurstBalloons {
    public int maxCoins(int[] nums){
        int len = nums.length;
        int opt[][] = new int[len+2][len+2];
        int[] coins = new int[len+2];
        coins[0] = 1;
        coins[len+1] = 1;
        int max = 0;
        for(int i=0;i<len;i++){
            coins[i+1] = nums[i];
        }
        for(int size = 1;size<=len;size++){
            for(int i = 1;i<len+2-size;i++){
                for(int j = 1;j<=size;j++){
                    opt[i][i+size-1]=Math.max(opt[i][i+size-1],coins[i+j-1]*coins[i-1]*coins[i+size]+opt[i][i+j-2]+opt[i+j][i+size-1]);
                    max = Math.max(opt[i][i+size-1],max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BurstBalloons test = new BurstBalloons();
        int[] list = {3,1,5,8};
        test.maxCoins(list);
    }
}
