package internpractice.Netease;

import java.util.Scanner;

public class Netease2020_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int B = in.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
        }

        Integer[][] opt = new Integer[n+1][B+1];

        int sum = 0;
        for(int i = 1;i<=n;i++){
            sum+=nums[i-1]-1;
            opt[i][1] = sum;
        }

        for(int i=1;i<=B;i++){
            opt[1][i] = Math.abs(i-nums[0]);
        }

        int result = helper(opt,n,B,nums);
        System.out.println(result);
    }
    private static int helper(Integer[][] dp, int n, int target, int[]h){
        if (dp[n][target] != null) {
            return  dp[n][target];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= target; i++) {
            if (target % i != 0) {
                continue;
            }
            int j = target / i;
            min = Math.min(min, helper(dp, n-1, j, h) + Math.abs(h[n-1] - i));
        }
        return dp[n][target] = min;

    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int target = scanner.nextInt();
//
//        int[] h = new int[n];
//        for(int i = 0; i < n; i++) {
//            h[i] = scanner.nextInt();
//        }
//
//        //dp[i][j] 表示前i个数字 使得为j 所需要的代价
//        Integer[][] dp = new Integer[n+1][target + 1];
//
//        int sum = 0;
//        for(int i = 1; i <= n; i++) {
//            sum += h[i-1] - 1;
//            dp[i][1] = sum;
//        }
//
//        for (int j = 1; j <= target; j++) {
//            dp[1][j] = Math.abs(j - h[1-1]);
//        }
//
//
//        int result = doCheck(dp, n, target, h);
//
//        System.out.println(result);
//
//    }
//
//    private static int doCheck(Integer[][] dp, int n, int target, int[] h) {
//        if (dp[n][target] != null) {
//            return  dp[n][target];
//        }
//
//        //dp[n][target] == null
//
//        int min = Integer.MAX_VALUE;
//        for (int i = 1; i <= target; i++) {
//            if (target % i != 0) {
//                continue;
//            }
//
//            int j = target / i;
//            min = Math.min(min, doCheck(dp, n-1, j, h) + Math.abs(h[n-1] - i));
//        }
//
//
//        return dp[n][target] = min;
//    }
}
