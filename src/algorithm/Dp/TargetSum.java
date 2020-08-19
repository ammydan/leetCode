package algorithm.Dp;


import java.util.HashMap;

/**
 * middle 494
 * 快速找出重叠部分，特殊值0检验一遍。
 * 在做memo记录的时候如果index出现了负数，我们可以使用hashmap。
 * 这里可能出现负数，那么我们需要的其实就是要把这个提升范围即可。
 * */
public class TargetSum {
//    private int len;
//    private int[] nums;
//    private int target;
//    private int[] signal = {-1,1};
//    private HashMap<String, Integer> map;
//    public int findTargetSumWays(int[]nums,int S){
//        len = nums.length;
//        this.nums = nums;
//        this.target = S;
//        this.map = new HashMap<>();
//        return helper(0,0);
//    }
//    private int helper(int n, int sum){
//        if(map.get(n+","+sum)!=null)return map.get(n+","+sum);
//        if(n==len){
//            if(sum == target) return 1;
//            else return 0;
//        }
//        int num = 0;
//        for(int i:signal){
//            num+=helper(n+1,sum+i*nums[n]);
//        }
//        map.put(n+","+sum,num);
//        return num;
//    }
    public int findTargetSumWays(int[]nums,int S){
        int len = nums.length;
        int max = 0;
        for(int i=0;i<len;i++){
            max+=nums[i];
        }
        if(S>max)return 0;
        int[][] opt = new int[len+1][2*max+1];
        opt[0][max] = 1;
        for(int i=1;i<=len;i++){
            for(int j=0;j<=2*max;j++){
                int l = (j-nums[i-1]>=0)?j-nums[i-1]:0;
                int r = (j+nums[i-1]<=2*max)?j+nums[i-1]:2*max;
                opt[i][j] = opt[i-1][l]+opt[i-1][r];
            }
        }
        return opt[len][max+S];
    }
}
