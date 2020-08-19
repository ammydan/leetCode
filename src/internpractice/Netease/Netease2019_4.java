package internpractice.Netease;

import java.util.Scanner;

public class Netease2019_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t>0){
            long n = in.nextLong();
            long k = in.nextLong();
            long ans = (n-k)>(k-1)?k-1:n-k;
            if(ans<0)ans = 0;
            System.out.println(0+" "+ans);
            t--;
        }
    }
}
