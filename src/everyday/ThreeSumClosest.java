package everyday;

import java.util.Arrays;

/**
 * middle 16
 * 本来先试试自己的方法，然后就通过了。
 * 1、自己的思想
 * 第一个想法就是这个题目似乎写过，然后再仔细看，发现稍有不同。不同之处在于不用寻找恰好等于target的数，而是寻找最接近的。此时心里一盘算，
 * 这个肯定要遍历完全部的可能（哪怕用动态规划也不能从n^3减到n^2，），能提前预知相应的大小减少遍历的次数的似乎就只有排序后的数组了。
 * 最后确定的是排序+双指针
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * */
public class ThreeSumClosest {
    public int threeSumClosest(int[]nums,int target){
        Arrays.sort(nums);
        int ans=0,delta=Integer.MAX_VALUE;
        int left, right;
        for(int i=0;i<nums.length;i++){
            left = i+1;
            right = nums.length-1;
            while(left<right){
                int temp = nums[i]+nums[left]+nums[right];
                if(Math.abs(target-temp)<delta){
                    ans = temp;
                    delta = Math.abs(target-temp);
                    if(delta==0)return ans;
                }
                if(temp-target<0)left++;
                else right--;
            }
        }
        return ans;
    }
}
