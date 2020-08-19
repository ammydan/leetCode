package contest.baidu2020;

import java.util.LinkedList;
import java.util.Scanner;

public class Poker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList<int[]> list = new LinkedList<>();
        int num = in.nextInt();
        for(int i=0;i<num;i++){
            int[] data = new int[3];
            data[0] = in.nextInt();
            data[1] = in.nextInt();
            data[2] = in.nextInt();
            list.add(data);
        }
        for(int[] piece:list){
            int temp = piece[0];
            int ans = 0;
            while(temp>=piece[1]){
                temp = (int) (temp-Math.floor(piece[2]*piece[1]/100.0));
                ans++;
            }
            System.out.println(ans);
        }
    }
}
