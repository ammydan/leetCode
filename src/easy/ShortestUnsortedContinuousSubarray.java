package easy;

import java.util.LinkedList;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums){
        int len = nums.length;
        if(len<=1)return 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        int start = len,end = -1;
        for(int i=1;i<len;i++){
            int tempstart = len+1;
            while(!stack.isEmpty()&&nums[stack.peekFirst()]>nums[i]){
                tempstart = stack.pop();
            }
            if(tempstart!=len+1){
                start = Math.min(start,tempstart);
                end = Math.max(end,i);
            }
            stack.push(i);

        }
        if(start==len)return 0;
        return end-start+1;
    }

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray test = new ShortestUnsortedContinuousSubarray();
        test.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15
        });
    }
}
