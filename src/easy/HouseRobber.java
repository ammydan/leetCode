package easy;

//非连续求最大值，还有一部分题目是连续求最大值
public class HouseRobber {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len==0)return 0;
        if(len==1)return nums[0];
        int[] money = new int[len+1];
        money[0] = 0;
        money[1] = nums[0];
        for(int i=2;i<=len;i++){
            money[i] = Math.max(money[i-1],money[i-2]+nums[i-1]);
        }
        int start=0, end=0;
        for(int i=1;i<=len;i--){
            if(money[i]!=money[len]){
                end = i;
            }
            if(money[i]==nums[i]){
                start = i;
                break;
            }
        }
        System.out.println("strat: "+start+" end: "+end);

        return money[len];
    }


}
