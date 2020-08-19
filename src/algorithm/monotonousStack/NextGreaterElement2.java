package algorithm.monotonousStack;

import java.util.LinkedList;

public class NextGreaterElement2 {
    public int[] nextGreaterElement(int[] nums){
        int len = nums.length;
        LinkedList<Integer> stack = new LinkedList<>();
        int [] ans = new int[len];
        for(int i=2*len-1;i>=0;i--){
            while(!stack.isEmpty()&&stack.peek()<=nums[i%len]){
                stack.pop();
            }
            ans[i%len] = stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i%len]);
        }
        return ans;
    }
}
