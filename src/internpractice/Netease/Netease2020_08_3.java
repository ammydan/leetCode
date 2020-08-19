package internpractice.Netease;

import java.util.Scanner;

public class Netease2020_08_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T>0){
            int n = in.nextInt();
            int[] nums = new int[n];
            for(int i=0;i<n;i++){
                nums[i] = in.nextInt();
            }
            if(valid(nums))System.out.println(0);
            int[]temp = nums.clone();
            boolean flag = false;
            for(int i = 1;i<=n-2;i++){
                for(int j = 0;j<i;j++){

                }
            }
            T--;
        }
    }
    public static boolean valid(int []nums){
        int a = 0, b = 0;
        for(int i=0;i<nums.length;i++){
            if(a>b)b+=nums[i];
            else a+=nums[i];
        }
        return a==b;
    }
}
