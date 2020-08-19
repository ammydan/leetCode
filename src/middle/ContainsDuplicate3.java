package middle;

import java.util.Arrays;
import java.util.TreeSet;
/**
 * middle 220
 * 1、自己的想法
 * 第一次看当然毫不犹豫地使用暴力破解方法，毕竟暴力破解也没有重复的地方。但是发现行不通，超时了！！！
 * 这题也没办法用DP，因为你会发现根本没有重复使用的地方。那么既然是数字，必然有顺序才能解决。肯定也不是将原来的数组排序，
 * 因为这样的话是O(nlogn)的时间复杂度了，而且丢失了元素的排位顺序，比原来没有好多少。
 * 那么我们可以将需要比较的候选元素进行排序，然后比完子之后删掉最前面的一位（位置最靠前的）
 * 时间复杂度：O(nlogm)
 * 时间复杂度：O(m)
 * */
public class ContainsDuplicate3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
//        1、暴力破解法
//        int len = nums.length;
//        for(int i=0;i<len;i++){
//            int index = 1;
//            while(index<=k&&i+index<len){
//                long temp = nums[i];
//                if(Math.abs(temp-nums[i+index++])<=t){
//                    return true;
//                }
//            }
//        }
//        return false;
//        2、参考方法①：平衡二叉树
        TreeSet<Integer> bt = new TreeSet<>();
        int len = nums.length;
        for(int i=0;i<len;i++){
            Integer temp = bt.ceiling(nums[i]);
            if(temp!=null&&temp<=nums[i]+t)return true;

            temp = bt.floor(nums[i]);
            if(temp!=null&&nums[i]<=temp+t)return true;

            bt.add(nums[i]);
            if(bt.size()>k) bt.remove(nums[i-k]);
        }
        return false;
    }

    public static void main(String[] args) {
        long temp = 2147483647;
        int i = 1;
        System.out.println(temp+i);
    }
}
