package middle;

import java.util.HashMap;
import java.util.HashSet;

/**
 * middle 421
 * 1、自己的想法
 * 一开始，直接想暴力破解。后来想着是不是要按位处理，但是一直理不清楚头绪。
 * 时间复杂度：O(n^2)
 * 空间复杂度:O(1)
 * 2、参考思路
 * ①按位比较
 * a^b=max;max^a=b;max^b=a，每一位进行比较，前面的进行保留放入set中，然后再按照预期max进行比较，如果答案合理则完成了。
 *
 * */
public class MaximumXORofTwoNumbersinanArray {
    class Node{
        HashMap<Integer,Node> map;
        boolean val;
        public Node(boolean val){
            this.val = val;
            map = new HashMap<>();
        }
        public Node(){
            this.val = false;
            map = new HashMap<>();
        }
    }
    public int findMaximumXOR(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        int max = 0, maxBit=0;
        int mask = 0;
        for(int i=30;i>=0;i--){
            set.clear();
            mask = mask|(1<<i);
            for(int num:nums){
                set.add(mask&num);
            }
            maxBit = max|(1<<i);
            for(int bits:set){
                if(set.contains(bits^maxBit)){
                    max = maxBit;
                    break;
                }
            }
        }
        return max;

    }
}
