package algorithm.monotonousStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[]nums1, int []nums2){
        LinkedList<Integer> stack = new LinkedList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int [] ans = new int[len1];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=len2-1;i>=0;i--){
            while(!stack.isEmpty()&&stack.peek()<=nums2[i]){
                 stack.pop();
            }
            int val = stack.isEmpty()?-1:stack.peek();
            map.put(nums2[i],val);
            stack.push(nums2[i]);
        }
        for(int i=0;i<len1;i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        NextGreaterElement1 test = new NextGreaterElement1();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        test.nextGreaterElement(nums1,nums2);
    }
}
