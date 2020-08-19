package everyday;

import java.util.Arrays;

/**
 * middle 209
 * 发现自己对子串和子序列的题目总是捉襟见肘，这里总结一下子串和子序列的区别和特点，以便下次能够快速想出解决方案
 * 子串：表示在S中出现了（题目中常常表现为连续子集）
 * 子序列：除去S中我们不需要的元素，然后获得的相应的子集。（即保持相对的位置不变）
 * 1、自己的想法：
 * 其实一开始自己已经很接近参考方法3了，但是错误的估计了时间复杂度，导致直接放弃这个思路。
 * 2、参考思想
 * ①暴力破解
 * 没什么好说的固定好起始位置直接开干（这里可以稍微总结以下，子串都是要以源字符串某一个元素作为起点所以我们可以稍微参考以下暴力破解的思路）
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 * ②前缀和+二分查找
 * 这里的二分查找用得十分巧妙，也是承接暴力破解而来的。想想我们如何查找到每一个起点的最小终止序号其和>=s?。我们可以先用前缀和（因为都是正整数，所以自然而然地是递增的）。
 * 这样我们用二分法查找sums[i]+s，这样获得的序号可以作为我们的这个查询的起点。
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 * ③双指针/滑动窗口
 * 因为子串必须是S一部分，所以使用滑动窗口其实是自然而然地事情。
 * 如果双指针的sum>=s，我们此时就需要做一个记录，然后移动left++，sum减去nums[left]，直到sum<s;
 * 如果sum<s，我们移动right，并且加到sum中。
 * 这个过程持续到right>=len
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums){
//        1、参考方法1：暴力破解
//        int len = nums.length;
//        if(len==0)return 0;
//        int ans = Integer.MAX_VALUE;
//        for(int i=0;i<len;i++){
//            int sum =0;
//            for(int j=i;j<len;j++){
//                sum+=nums[j];
//                if(sum>=s){
//                    ans = Math.min(ans,j-i+1);
//                    break;
//                }
//            }
//        }
//        return ans;
//        2、参考方法2：前缀和+二分查找
//        int len = nums.length;
//        if(len==0)return 0;
//        int[] sums = new int[len+1];
//        int ans = Integer.MAX_VALUE;
//        for(int i=1;i<=len;i++){
//            sums[i] = sums[i-1]+nums[i-1];
//        }
//        for(int i=0;i<len;i++){
//            int temp = s+sums[i];
//            int index = Arrays.binarySearch(sums,temp);
//            if(index<0)index = -index-1;
//            if(index<=len){
//                ans = Math.min(ans,index-i);
//            }
//        }
//        return ans == Integer.MAX_VALUE? 0:ans;
//        3、参考方法3：双指针/滑动窗口
        int len = nums.length;
        if(len==0)return 0;
        int ans = Integer.MAX_VALUE;
        int left=0,right = 0;
        int sum = 0;
        while(right<len){
            sum += nums[right];
            while(sum>=s){
                ans = Math.min(ans,right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();
        int []array = {2,3,1,2,4,3};
        test.minSubArrayLen(7,array);
    }
}
