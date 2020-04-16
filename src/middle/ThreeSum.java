package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/***
 * Sometimes Sort can help us add some extra conditions, like comparing.
 *
 * ******/

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<len;i++){
            if(i>0&&i<len&&nums[i-1]==nums[i])continue;
            int temp = -nums[i];
            int left = i+1;
            int right = len-1;
            while(left<right){
                int temp2 = nums[right]+nums[left];
                if(temp2>temp)right--;
                else if(temp2<temp)left++;
                else{
                    List<Integer> threeSum = new ArrayList<>();
                    threeSum.add(nums[i]);
                    threeSum.add(nums[left]);
                    threeSum.add(nums[right]);
                    list.add(threeSum);
                    left++;
                    while(left<len&&nums[left]==nums[left-1])left++;
                    right--;
                    while(right>0&&nums[right]==nums[right+1])right--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ThreeSum test = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(test.threeSum(nums));
    }
}
