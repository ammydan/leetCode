package internpractice;

import java.util.Scanner;

public class LargestSum {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n==0)return;
        int tempSum = in.nextInt();
        int ans = tempSum;
        for(int i=1;i<n;i++){
            int current = in.nextInt();
            if(tempSum>=0)tempSum +=current;
            else tempSum = current;
            if(tempSum>ans)ans = tempSum;
        }
        System.out.println(ans);
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0; i< n; i++){
//            arr[i] = in.nextInt();
//        }
//        int res = arr[0];
//        int cursum = arr[0];
//        for(int i = 1; i < n; i++){
//            cursum += arr[i];
//            if(cursum <= 0){
//                cursum = arr[i];
//            }
//            if(cursum > res){
//                res = cursum;
//            }
//        }
//        System.out.println(res);
    }

}
