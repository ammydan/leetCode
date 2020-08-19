package everyday;

import java.util.Arrays;
/**
 * easy 35
 * 已经明示要考二分搜索法了。
 * */
public class SearchInsertPosition {
    public int searchInsert(int[] nums,int target){
//        1、站在巨人的肩膀上
//        int temp = Arrays.binarySearch(nums, target);
//        if(temp<0)temp = -temp-1;
//        return temp;
//        2、手动二分法
//        int len = nums.length;
//        int left = 0, right = len;
//        int mid = 0;
//        while(right>left){
//            mid = left+(right-left)/2;
//            if(target==nums[mid])return mid;
//            if(target>nums[mid]){
//                if(mid+1<len&&target<nums[mid+1])return mid+1;
//                left = mid+1;
//            }else if(target<nums[mid]){
//                if(mid-1>=0&&target>nums[mid-1])return mid;
//                right = mid;
//            }
//        }
//        if(left==len)return len;
//        return mid;
//        3、参考的二分法实现
        int len = nums.length;
        int left = 0, right = len, ans = len;
        while(left<right){
            int mid = ((right-left)>>1)+left;
            if(target<=nums[mid]){
                ans = mid;
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SearchInsertPosition test = new SearchInsertPosition();
        int[] list = {1,3,5,6};
        test.searchInsert(list,7);
    }
}
