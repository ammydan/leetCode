package middle;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int currentMax = 0;
        int positionMax[] = new int[len];
        int positionMin[] = new int[len];
        positionMax[0] = nums[0];
        positionMin[0] = nums[0];
        currentMax = nums[0];

        for(int i = 1;i<len;i++){
            positionMax[i] = Math.max(Math.max(positionMin[i-1]*nums[i],positionMax[i-1]*nums[i]),nums[i]);
            positionMin[i] = Math.min(Math.min(positionMin[i-1]*nums[i],positionMax[i-1]*nums[i]),nums[i]);
            currentMax = Math.max(positionMax[i],currentMax);
        }
        return currentMax;
    }

    public static void main(String[] args) {
        MaximumProductSubarray test = new MaximumProductSubarray();
        int[] nums = {2,3,-2,4};
        test.maxProduct(nums);
    }
}
