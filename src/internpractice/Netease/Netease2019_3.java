package internpractice.Netease;

import java.util.Scanner;

public class Netease2019_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t>0){
            long n = in.nextLong();
            long m = in.nextLong();
//            long ans = Math.abs((n-2)*(m-2));
            long ans = 0;
            if(n==1&&m==1){
                ans = 1;
            }else if(n==1){
                ans = m-2;
            }else if(m==1){
                ans = n-2;
            }else{
                long temp = (n-2)*(m-2);
                if(temp<0)ans = -temp;
                else ans = temp;
            }
            System.out.println(ans);
            t--;
        }
    }
}
