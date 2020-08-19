package algorithm.binarySearch;

public class FindtheRightNumber {
    public int findtherightnumber(int[] nums, int target){
        int len = nums.length;
        int left = 0;
        int right = len;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                left = mid+1;
            }else if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid;
            }
        }
        return left-1;
    }
}
