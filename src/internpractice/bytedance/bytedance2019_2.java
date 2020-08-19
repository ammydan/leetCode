package internpractice.bytedance;

import java.util.Scanner;

public class bytedance2019_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int D = in.nextInt();
        long ans = 0;
        int[] position = new int[N];
        for(int i=0;i<N;i++){
            position[i] = in.nextInt();
//            System.out.println(position[i]);
        }
//        in.close();
        for(int i=2;i<N;i++){
            for(int j=0;j<N-i;j++){
                if(position[j+i]-position[j]<=D)ans=ans+i-1;
            }
        }
//        int left =0, right = 2;
//        while(right<N){
//            if(position[right]-position[left]>D)left++;
//            else if(right-left<2)right++;
//            else{
//                long temp = right-left;
//                ans += temp*(temp-1)/2;
//                right++;
//            }
//        }
        System.out.println(ans%99997867);

    }
//    private int mod = 99997867;
//
//    private void sln() {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt(), D = sc.nextInt();
//        long cnt = 0;
//        if (N <= 2) {
//            System.out.println(-1);
//            return;
//        }
//        int[] locs = new int[N];
//        for (int i = 0; i < N; i++) {
//            locs[i] = sc.nextInt();
//        }
//        sc.close();
//        int left = 0, right = 2;
//        while (right < N) {
//            if (locs[right] - locs[left] > D) left++;
//            else if (right - left < 2) right++;
//            else {
//                cnt += calC(right - left);
//                right++;
//            }
//        }
//        cnt %= mod;
//        System.out.println(cnt);
//    }
//
//    private long calC(long num) {
//        return num * (num - 1) / 2;
//    }
//
//
//    public static void main(String[] args) {
//        new bytedance2019_2().sln();
//    }
}
