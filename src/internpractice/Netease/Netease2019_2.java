package internpractice.Netease;

import java.util.Scanner;

public class Netease2019_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        int ans = 0;
        int sum = 0;
        int step = 5;
        while(sum<target){
            if(sum+step>target)step--;
            else if(sum+step<=target){
                sum+=step;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
