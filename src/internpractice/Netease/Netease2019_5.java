package internpractice.Netease;

import java.util.Scanner;

public class Netease2019_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long [] capacities = new long[n+1];
        long[] room = new long[n+1];
        for(int i = 1;i<=n;i++){
            capacities[i] = in.nextLong();
        }
        while(m>0){
            int order = in.nextInt();
            if(order==1){
                int k = in.nextInt();
                System.out.println(capacities[k]-room[k]);
            }else{
                int x = in.nextInt();
                long v = in.nextLong();
                while(v!=0){

                }
            }
            m--;
        }
    }
}
