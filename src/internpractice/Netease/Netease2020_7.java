package internpractice.Netease;

import java.util.Scanner;

public class Netease2020_7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t>0){
            int n = in.nextInt();
            int k = in.nextInt();
            boolean superPower = true;
            long[] heights = new long[n];
            for(int i=0;i<n;i++){
                heights[i] = in.nextLong();
            }
            int counter = 0;
            boolean flag = false;
            long current = heights[counter];
            while(counter<n-1&&!flag){
                long[] record = new long[2];
                if(heights[counter+1]>current){
                    if(superPower){
                        superPower=false;
                        counter = max(heights,counter,k);
                        current = heights[counter];
                        continue;
                    }
                    else {
                        flag = true;
                        break;
                    }
                }
                for(int i=1;i<=k&&counter+i<n;i++){
                    if(heights[counter+i]<=current){
                        if(record[1]<=heights[counter+i]){
                            record[0] = counter+i;
                            record[1] = heights[counter+i];
                        }
                    }
                }
                counter = (int) record[0];
                current = record[1];
            }
            if(flag)System.out.println("NO");
            else System.out.println("YES");
            t--;
        }
    }
    public static int max(long[] list, int start,int len){
        int end = start+len;
        int index = start+1;
        for(int i = start+1;i<=end&&i<list.length;i++){
            if(list[index]<=list[i])index = i;
        }
        return index;
    }

//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            int T = sc.nextInt();
//            int n = 0, k = 0;
//            for (int i = 0; i < T; i++) {
//                n = sc.nextInt();
//                k = sc.nextInt();
//                int[] nums = new int[n];
//                for (int j = 0; j < n; j++)
//                    nums[j] = sc.nextInt();
//                System.out.println(solution(n, k, nums));
//            }
//        }
//
//        public static String solution(int n, int k, int[] nums) {
//            int big = 1;
//            int index = 0;
//            while (index < nums.length - 1) {
//                int tmp = index;
//                int max = 0, max_index = index;
//                for (int j = index + 1; j < index + 1 + k && j < nums.length; j++) {
//                    if (nums[j] < nums[index]) {
//                        max_index = (max > nums[j]) ? max_index : j;
//                        max = Math.max(nums[j], max);
//                    }
//                }
//                index = max_index;
//                if (tmp == index && big > 0) {
//                    big--;
//                    max = 0;
//                    max_index = index;
//                    for (int j = index + 1; j < index + 1 + k && j < nums.length; j++) {
//                        max_index = (max > nums[j])? max_index : j;
//                        max = Math.max(nums[j], max);
//                    }
//                    index = max_index;
//                }
//                else if (tmp == index && big <= 0)
//                    return "NO";
//            }
//            return "YES";}
}
