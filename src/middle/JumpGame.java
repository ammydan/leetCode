package middle;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean []reach = new boolean[len];
        reach[0] = true;
        for(int i=1;i<len;i++){
            reach[i] = false;
            for(int j=i-1;j>=0;j--){
                if(reach[j]&&j+nums[j]>=i){
                    reach[i] = true;
                }
            }
        }
        return reach[len-1];
    }

    public static void main(String[] args) {
        JumpGame test = new JumpGame();
        int [] nums = {2,0,0};
        test.canJump(nums);
    }
}
