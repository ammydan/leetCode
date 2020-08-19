package algorithm.traceback;

import java.util.LinkedList;
import java.util.List;

/**
 * 46 middle
 * 回溯算法练习
 * */
public class Permutations {
    private List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums){
        ans = new LinkedList<>();
        LinkedList<Integer> trace = new LinkedList<>();
        helper(nums,trace);
        return ans;
    }
    private void helper(int[]nums,LinkedList<Integer> trace){
        if(trace.size()==nums.length){
            ans.add(new LinkedList<>(trace));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(trace.contains(nums[i]))continue;
            trace.add(nums[i]);
            helper(nums,trace);
            trace.removeLast();
        }
    }
}
