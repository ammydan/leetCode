package internpractice.Netease;

import java.util.Scanner;

public class Netease2020_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t>0){
            long a = in.nextInt();
            long b = in.nextInt();
            long p = in.nextInt();
            long q = in.nextInt();
            long num = 0;
            while(a<b){
                if(a+p>=b){
                    num++;
                    a +=p;
                }else{
                    num++;
                    p*=q;
                }
            }
            System.out.println(num);
            t--;
        }
    }
}
