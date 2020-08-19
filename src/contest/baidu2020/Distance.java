package contest.baidu2020;

import java.util.LinkedList;
import java.util.Scanner;

public class Distance {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        int num = in.nextInt();
        for(int i =0;i<num;i++){
            int n = in.nextInt();
            int ans = 0;
            for(int j=0;j<n;j++){
                int x = in.nextInt();
                for(int k: list){
                    ans = ans+Math.abs(x-k);
                }
                list.add(x);
            }
            System.out.println(ans);
            list.clear();
        }
    }
}
