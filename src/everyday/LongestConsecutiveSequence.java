package everyday;

import java.util.HashSet;

/**
 * Hard 128
 * 这道题，一开始我就有些走偏了，但是还是先记录下自己的一些想法：
 * 我原本的思路就是：
 * 1、如果只能有O(n)的时间复杂度的话，那么我就只能遍历原来的数组，但是我可以遍历多次（只要是常数次就完全可以）
 * 2、我就想着先找出最大和最小值，做一个桶排序的第一步，5个为一桶，然后桶内添加时找出桶内的最大值和最小值
 * 3、第一次遍历桶，找出最多连续满桶的
 * 4、如果没有满桶的那么遍历桶找出8个的或者没有8个就找出相应最大的；如果有最大连续满桶，那么我们就找到其前后两个桶找出有没有额外连续的。
 *自我评价：
 * 这个只是一个伪O(n)，因为时间复杂度和空间复杂度与数组的最大值相关，如果最大值和最小值的差值对比元素个数多太多，那么我的算法就完全不行。
 *
 * 参考思路：
 * 1、将原数组中的元素放进hashset中去重（因为重复元素并不能增加最大连续子数组的长度）
 * 2、我们将set里面的每个元素进行遍历，当作起始点x，x+1, x+2, x+3, x+4,……
 * 3、但是这个方法目前为止还是达不到O(n)的程度，我们想想，有些连续的元素是不是重复当作起点了？
 * 其实这个根本没有必要进行重复的计算，我们如何验证呢？我们想想如果一个元素不是已经遍历的连续元素，那么它x-1一定不存在在set中。
 * 到此，思路完全成型。
 * 时间复杂度:O(n)
 * 空间复杂度：O(n)
 * */

public class LongestConsecutiveSequence {
    public int longesetConsecutive(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for(int i: nums){
            set.add(i);
        }
        for(int i: set){
            if(!set.contains(i-1)){
                int j = i;
                int consecutive = 1;
                while(set.contains(++j))consecutive++;
                if(consecutive>max)max = consecutive;
            }
        }
        return max;
    }
}
