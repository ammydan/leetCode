package everyday;

import java.util.*;
/**
 * hard 315
 * */
public class CountofSmallerNumbersAfterSelf {
    private int [] count;
    private int lowbit(int x){
        return x&-x;
    }
    private void update(int index,int x){
        while(index<count.length){
            count[index] +=x;
            index +=lowbit(index);
        }
    }
    private int query(int index){
        int sum = 0;
        while(index>0){
            sum += count[index];
            index-=lowbit(index);
        }
        return sum;
    }
    public List<Integer> countSmaller(int[] nums){
        int len = nums.length;
        LinkedList<Integer> ans = new LinkedList<>();
        int[] list = nums.clone();
        int[] indexes = new int[len+1];
        count = new int[len+1];
        Arrays.sort(list);
        for(int i=0;i<len;i++){
            indexes[i] = Arrays.binarySearch(list,nums[i])+1;
        }
        for(int i=len-1;i>=0;i--){
            int num = query(indexes[i]);
            ans.push(num);
            update(indexes[i]-1,1);
        }
        return ans;
    }

    public static void main(String[] args) {
        CountofSmallerNumbersAfterSelf test = new CountofSmallerNumbersAfterSelf();
        int [] nums = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        test.countSmaller(nums);
    }
}
