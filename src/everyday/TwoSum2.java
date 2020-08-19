package everyday;
/**
 * 167 easy
 * 没啥好说的直接双指针相加就行。
 * */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target){
        int len = numbers.length;
        int left=0,right=len-1;
        while(left<right){
            int sum = numbers[left]+numbers[right];
            if(sum<target)left++;
            else if(sum>target)right--;
            else{
                int[] ans = new int [2];
                ans[0] = left+1;
                ans[1] = right+1;
                return ans;
            }
        }
        return null;
    }
}
