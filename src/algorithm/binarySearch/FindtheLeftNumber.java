package algorithm.binarySearch;

/**
 * 这个其实和java内部自带的算法有些相似，哪怕nums没有对应的target值，也会有对应的值进行返回。
 * 因为这个最终返回的是应该插入的位置。
 * */
public class FindtheLeftNumber {
    public int findtheleftnumber(int[]nums,int target){
        if(nums.length==0)return -1;
        int left = 0;
        int right = nums.length;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                right = mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid;
            }
        }
//        if(left==nums.length)return -1;
//        return nums[left]==target?left:-1;
        return left;
    }
}
