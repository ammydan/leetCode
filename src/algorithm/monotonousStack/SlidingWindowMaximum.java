package algorithm.monotonousStack;

import java.util.LinkedList;
/***
 * 239 hard
 * 还有的练习题： 901
 * */
public class SlidingWindowMaximum {
    private class MonoQueue{
        LinkedList<Integer> list = new LinkedList<>();
        public void add(int x){
            while(!list.isEmpty()&&list.peekLast()<x){
                list.removeLast();
            }
            list.add(x);
        }
        public int getMax(){
            return list.peekFirst();
        }
        public void delete(int x){
            if(list.peekFirst()==x)list.removeFirst();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k){
        int len = nums.length;
        if(len==0)return new int[0];
        if(len==1)return new int[]{nums[0]};
        MonoQueue q = new MonoQueue();
        for(int i=0;i<k;i++)
        {
            q.add(nums[i]);
        }
        int ans[] = new int[len-k+1];
        int index = 1;
        ans[0] = q.getMax();
        for(int i=k;i<len;i++){
            q.delete(nums[i-k]);
            q.add(nums[i]);
            ans[index++] = q.getMax();
        }
        return ans;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum test = new SlidingWindowMaximum();
//        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] nums = {1,-1};
        test.maxSlidingWindow(nums,1);
    }
}
