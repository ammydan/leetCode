package everyday;

import algorithm.monotonousStack.TrappingRainWater;

import java.util.*;

/**
 * 1、自己的思路：
 * ①先计算出每个元素所需的epxectSum（加起来等于0）
 * ②在遍历循环计算出所有twoSum可能放入hashmap中
 * ③最后再次遍历找出所有的组合。
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n^2)
 * 但是这段代码写出来之后，有一个硬伤就是可能出现重复的现象。(因为答案要求的是内容不能重复，而我只是保证了index不会重复）
 * 这里其实可以引申出一个解法，那就是如果要求内容不进行重复的话，可以先考虑使用排序来避免内容重复。
 *
 * 2、参考思路
 * ①排序+双指针。
 * 1)首先排序
 * 2)然后遍历整个数组，i：
 *  使用两个指针left和right对应i后面的前后两端进行遍历。
 *  如果nums[i]==nums[i-1]则continue，因为会出现重复的答案。
 *  如果sum = nums[i]+nums[left]+nums[right]>0,我们将right-1；反之，则left+1。
 *  sum==0时添加到ans中
 *
 * **/

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums){
//        1、自己的思路
//        int[] expectSum = new int[nums.length];
//        HashMap<Integer, ArrayList<Integer>> twoSum = new HashMap<>();
//        List<List<Integer>> ans = new LinkedList<>();
//        boolean[] flag = new boolean[nums.length];
//        for(int i=0;i<nums.length;i++){
//            expectSum[i] = 0 - nums[i];
//        }
//        for(int i=0;i<nums.length-1;i++){
//            for(int j=i+1;j<nums.length;j++){
//                int sum = nums[i]+nums[j];
//                if(twoSum.containsKey(sum)){
//                    ArrayList<Integer> temp = twoSum.get(sum);
//                    temp.add(i);
//                    temp.add(j);
//                }else{
//                    ArrayList<Integer> temp = new ArrayList<>();
//                    temp.add(i);
//                    temp.add(j);
//                    twoSum.put(sum,temp);
//                }
//            }
//        }
//        for(int i=0;i<nums.length;i++){
//           if(twoSum.containsKey(expectSum[i])){
//               ArrayList<Integer> theSum = twoSum.get(expectSum[i]);
//               int j=0;
//               while(j<theSum.size()){
//                   int one = theSum.get(j++);
//                   int two = theSum.get(j++);
//                   if(one==i||two==i)continue;
//                   if(!flag[one]||!flag[two]||!flag[i]){
//                       ArrayList<Integer> tempans = new ArrayList<>();
//                       tempans.add(nums[i]);
//                       tempans.add(nums[one]);
//                       tempans.add(nums[two]);
//                       flag[i] = true;
//                       flag[one] = true;
//                       flag[two] = true;
//                       ans.add(tempans);
//                   }
//               }
//           }
//        }
//        return ans;
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1])continue;
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[left]+nums[right]+nums[i];
                if(sum>0)right--;
                else if(sum<0)left++;
                else{
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    ans.add(temp);
                    while(left<right&&nums[left]==nums[++left]);
                    while(left<right&&nums[right]==nums[--right]);
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        ThreeSum test = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        test.threeSum(nums);
    }

}
