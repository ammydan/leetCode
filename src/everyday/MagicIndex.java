package everyday;
/**
 * easy 面试题 魔术索引
 *
 * */
public class MagicIndex {
    public int findMagicIndex(int[] nums){
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(i==nums[i])return i;
        }
        return -1;
    }
}
