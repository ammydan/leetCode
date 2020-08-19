package internpractice.Netease;

import java.util.Arrays;
import java.util.Scanner;

public class Netease2020_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int []list = new int[n];
        for(int i=0;i<n;i++){
            list[i] = in.nextInt();
        }
        Arrays.sort(list);
        for(int i=0;i<q;i++){
            int x = in.nextInt();
            int ans = 0;
            for(int j=n-1;j>=0;j--){
                if(list[j]>=x){
                    list[j]--;
                    ans++;
                }
            }
            System.out.println(ans);
        }
//        int []list= new int[4];
//        list[0] = 2;
//        list[1] = 4;
//        list[2] = 4;
//        list[3] = 10;
//        System.out.println(Arrays.binarySearch(list,3));
//        System.out.println(Arrays.binarySearch(list,11));

    }

}
