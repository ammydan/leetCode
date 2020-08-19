package algorithm.binarySearch;

public class AllBinarySearch {
    public int binarySearch(int nums[],int target){
        int len = nums.length;
        int left = 0,right = len-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target)return mid;
            else if(nums[mid]>target)right = mid -1;
            else if(nums[mid]<target)left = mid+1;
        }
        return -1;
    }
    public int leftBound(int nums[],int target){
        int len = nums.length;
        int left = 0, right = len-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target) right = mid-1;
            else if(nums[mid]>target) right = mid-1;
            else if(nums[mid]<target) left = mid+1;
        }
//        return left;
        if(left>=len||nums[left]!=target)return -1;
        return left;
    }
    public int rightBound(int nums[],int target){
        int len = nums.length;
        int left = 0,right = len-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target) left = mid+1;
            else if(nums[mid]<target)left = mid+1;
            else if(nums[mid]>target)right = mid-1;
        }
//        return right;
//        如果是开区间的话需要返回 right-1
        if(right<0||nums[right]!=target) return -1;
        return right;
    }
}
