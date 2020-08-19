
package everyday;

import java.util.Random;

/**
 * middle 215
 * 这道题其实之前应该遇到过，但是自己总是只记住了堆方法而忘记了快排方法来处理找到第K个大的元素了。
 * 1、自己的想法
 * ①第一个当然是根据这个数组创建一个大小堆，然后提取K次，即为第K个大的元素。
 * ②注意的地方：java根本没有大堆，如果你用comparator来创建heap那么根本不可能直接heapify了，所以我这里直接用长度减去需要的k然后反向获取。
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 * 2、参考方法
 * ①快排
 * 注意partition中array必须大于1，如果不满足则会出现错误。
 * */
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k){
//        1、堆的方法
//        ArrayList<Integer> list = new ArrayList<>();
//        for(int i:nums){
//            list.add(i);
//        }
//        PriorityQueue<Integer> pq = new PriorityQueue<>(list);
//        int ans = 0;
//        k = nums.length-k+1;
//        while(k>0){
//            ans = pq.remove();
//            k--;
//        }
//        return ans;
        if(nums.length==1)return nums[0];
        int index = partition(nums,0,nums.length);
        int left = 0, right = nums.length;
        while(index!=-1&&index<nums.length&&index!=k-1){
            if(index>k-1){
                right = index;
                if(right-left<2)return nums[left];
                index = partition(nums,left,right);
            }else{
                left = index+1;
                if(right-left<2)return nums[right-1];
                index = partition(nums,left,right);

            }
        }
        return index==k-1?nums[index]:0;
    }
//记住这里的使用，数组的元素个数必须大于1个。
    private int partition(int[] nums,int left,int right){
        int pos = left;
        int l = left, r = right;
        while(l<=r){
            while(nums[++l]>nums[pos]){
                if(l==right-1)break;
            }
            while(nums[--r]<nums[pos]){
                if(r==left)break;
            }
            if(l>=r)break;
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
        int temp = nums[pos];
        nums[pos] = nums[r];
        nums[r] = temp;
        return r;
    }
    public static void main(String[] args) {
//        int[] array = {3,2,1,5,6,4};
//        int[] array = {2,1};
        int[] array = {5,2,4,1,3,6,0};
        KthLargestElementinanArray test = new KthLargestElementinanArray();
        test.findKthLargest(array,4);
    }

}
