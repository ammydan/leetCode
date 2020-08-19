package everyday;

/**
 * Hard 41
 * 1、自己的想法
 * 看着时间和空间的要求，心里一惊。然后一心想着怎么利用常数个空间记住整个数组遍历的情况，这完全进入了错误的方向
 * 如果我要是真能想出来，估计要给我颁奖了。
 *
 * 2、参考思路
 * ①哈希表。
 * 数组N个数字，那么我们答案的最终结果肯定在[1,N+1]中。将负数变成N+1，可以让我们继续。我们只顾着看着只能用常数个额外
 * 空间，但是并没有看见传递过来数组我们也可以利用。对于x∈[1,N]的数字，我们标记该数组为负数。然后再来一次遍历。
 * 看最早不是负数的位置即为答案，否则是N+1。注意每次要取出来的数字必须变成绝对值。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 其实这里如果运用在真正的生产环境，我们还需要将这个复原，因为这个数组在接下来的步骤中可能还要被使用。
 * ②置换（O(n)复杂度来进行排序）
 *  遍历的时候，如果nums[i]≠i+1那么我们就将其进行置换，直到nums[i]=i+1，而且nums[i]!=nums[nums[i]]
 * */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums){
//        1、参考方法①：哈希表
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]<=0){
//                nums[i] = nums.length+1;
//            }
//        }
//        for(int i=0;i<nums.length;i++){
//            int temp = Math.abs(nums[i]);
//            if(temp<=nums.length){
//                nums[temp-1] = -Math.abs(nums[temp-1]);
//            }
//        }
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]>0){
//                return i+1;
//            }
//        }
//        return nums.length+1;
//        2、参考方法②：置换
        int len = nums.length;
        for(int i=0;i<len;i++){
            while(nums[i]>0&&nums[i]<=len&&nums[i]!=nums[nums[i]-1]){
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[temp-1] = temp;
            }
        }
        for(int i=0;i<len;i++){
            if(i+1!=nums[i])return i+1;
        }
        return len+1;
    }
}
