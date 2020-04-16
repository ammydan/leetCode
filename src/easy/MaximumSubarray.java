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

    }

    public static void main(String[] args) {
        MaximumSubarray test = new MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(test.maxSubArray(nums));
    }
}

