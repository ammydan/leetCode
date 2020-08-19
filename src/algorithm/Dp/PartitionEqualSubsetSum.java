package algorithm.Dp;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums){
        int len = nums.length;
        int sum = 0;
        for(int i=0;i<len;i++){
            sum +=nums[i];
        }
        if(sum%2!=0)return false;
        int target = sum/2;
        boolean[][] opt = new boolean[len+1][target+1];
        for(int i = 0;i<=len;i++){
            opt[i][0] = true;
        }
        for(int i=1;i<=len;i++){
            for(int j=1;j<=target;j++){
                if(j-nums[i-1]<0)opt[i][j] = false;
                else{
                    opt[i][j] = opt[i-1][j-nums[i-1]]||opt[i-1][j];
                }
            }
        }
        return opt[len][target];
    }

}
