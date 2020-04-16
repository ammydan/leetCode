package hard;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int n = len+2;
        int [] extend = new int[n];
        for(int i=1;i<len+1;i++)extend[i] = nums[i-1];
        extend[0] = 1;
        extend[len+1] = 1;
        int[][] maxCoinsMemo = new int [n][n];

        for(int k=1;k<=len;k++){
            for(int left=0;left<n-k-1;left++){
                int right = left+k+1;
                for(int i=left+1;i<right;i++){
                    maxCoinsMemo[left][right] = Math.max(maxCoinsMemo[left][right],
                            extend[i]*extend[right]*extend[left]+maxCoinsMemo[left][i]+maxCoinsMemo[i][right]);
                }

            }
        }
        return maxCoinsMemo[0][len+1];
    }
    //        This is a wrong DP, because the right part we have not calculate.
//        for(int i=0;i<len;i++){
//            for(int j=i+2;j<len+2;j++){
//                for(int k=i+1;k<j;k++){
//                    maxCoinsMemo[i][j] = Math.max(maxCoinsMemo[i][j],extend[k]*extend[i]*extend[j]+maxCoinsMemo[i][k]+maxCoinsMemo[k][j]);
//                }
//            }
//        }

    public static void main(String[] args) {
        BurstBalloons test = new BurstBalloons();
        int[]nums = {3,1,5,8};
        System.out.println(test.maxCoins(nums));
    }
}
