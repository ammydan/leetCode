package contest.contest20200628;

import java.util.Arrays;
/**
 * middle 1498
 * 还是一个子序列的题目，如果题目要求与子序列的顺序无关，子序列并不在乎原来S的样子，只需要考虑子序列中需要有什么元素就行。
 * 无论是子序列还是子串比较常有的就是双指针解法（滑动窗口）
 * */
public class NumSubSeq {
    public int numSubseq(int[] nums,int target){
        Arrays.sort(nums);
        int ans = 0;
        int rest = (int) (Math.pow(10,9)+7);
        int left = 0, right = nums.length-1;
        int []pow = new int[nums.length];
        pow[0] = 1;
        for(int i =1;i<nums.length;i++){
            pow[i] = pow[i-1]*2;
            pow[i]%=rest;
        }
        while(left<=right){
            if(nums[right]+nums[left]<=target) {
                ans = (int) ((ans+ pow[left-right] )% rest);
                left++;
            }else right--;
        }
        return ans;
    }
}
