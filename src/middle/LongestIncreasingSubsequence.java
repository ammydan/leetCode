package middle;

import java.util.Arrays;

/***
 * 300. Longest Increasing Subsequence
 * 方法一：动态规划。
 * 我们一开始会很容易自然而然地想到最优子数组的连续递增数与增加一个的比较。
 * 但是这里有一个问题就是我们无法知道该子数组的递增子序列的最后一个元素是什么。
 * 因此我们第一个猜想就无法执行。
 * 接着我们的第二个猜想：既然我们一定要知道最后一个子序列的大小，那我们干脆假设opt[i]是以i结尾的
 * 子序列的最大值。这样我们就可以得到一个转移方程：
 * if(nums[j]<nums[i])
 *  opt[i] = max(opt[j]+1,opt[i])
 * 这里我们需要比较所有i以前的子序列，因为我们并不知道哪一个加上这个元素可以得到以i结尾的元素最优。
 * 而且这中间我们是保留了以某个特殊位置的元素结尾最优所以整个数组最优解应该还需要一个max来记录。
 * 初始化：
 * for all i
 * nums[i]=1
 * 时间复杂度:O(n^2)
 * ***/
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<1)return 0;
        if(nums.length<2) return 1;
        int[] opt = new int[nums.length];
        Arrays.fill(opt,1);
        int max = 0;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])opt[i] = Math.max(opt[i],opt[j]+1);
            }
            if(max<opt[i]) max = opt[i];
        }
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence test = new LongestIncreasingSubsequence();
        int[] nums={1,3,6,7,9,4,10,5,6};
        int ans = test.lengthOfLIS(nums);
        System.out.println(ans);

    }
}
