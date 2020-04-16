package easy;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int len2 = nums.length;
        int pre=0;
        for(int i=1;i<len;i++){
            if(nums[i]!=nums[pre]){
                nums[++pre]=nums[i];
            }else{
                len2--;
            }
        }
        return len2;
    }
}
