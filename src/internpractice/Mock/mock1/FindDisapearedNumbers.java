package internpractice.Mock.mock1;

import java.util.LinkedList;
import java.util.List;

public class FindDisapearedNumbers {
    public List<Integer> findDisapearedNumbers(int [] nums){
        int len = nums.length;
        int temp = 0;
        LinkedList<Integer> ans = new LinkedList<>();
        for(int i=0;i<len;i++){
            temp = nums[i];
            if(temp==i+1)continue;
            while(nums[i]!=i+1&&nums[temp-1]!=temp){
                nums[i] =  nums[temp-1];
                nums[temp-1] = temp;
                temp = nums[i];
            }
        }
        for(int i=0;i<len;i++){
            if(nums[i]!=i+1)ans.add(i+1);
        }
        return ans;
    }
}
