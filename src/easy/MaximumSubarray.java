package easy;

/***
 * 1、Do not fall into negative trap!
 * 2、If the initial is not sure, how about the first value of the array.
 * 3、We should notice the situation that we might not step into the loop.
 * **/
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int current=nums[0], maxValue=nums[0];
        for(int i=1;i<len;i++){
            current = current+nums[i]>nums[i]?current+nums[i]:nums[i];
            maxValue = maxValue>current?maxValue:current;
        }
        return maxValue;
//        下面这个动态规划无法满足至少取一个子数组的要求。
//        int len = nums.length;
//        if(len==0)return 0;
//        if(len==1)return nums[0];
//        int [][] opt = new int[len][2];
//        opt[0][0] = 0;
//        opt[0][1] = nums[0];
//        for(int i=0;i<len;i++){
//            opt[i][0] = Math.max(opt[i-1][0],opt[i-1][1]);
//            opt[i][1] = Math.max(opt[i-1][1]+nums[i],nums[i]);
//        }
//        return opt[len][0]>opt[len][1]?opt[len][0]:opt[len][1];

    }

    public static void main(String[] args) {
        MaximumSubarray test = new MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(test.maxSubArray(nums));
    }
}

