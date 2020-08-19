package internpractice.Netease;

import java.util.HashSet;
import java.util.Scanner;
/**
 * 为什么感觉做笔试题，总觉得自己想得太多，导致进入死胡同。
 * 这题只要遍历n就行了，利用了一些简单的位运算的方法。
 * */
public class Netease2020_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        HashSet<Integer> set = new HashSet<>();
        while(q>0){
            int operate = in.nextInt();
            int x = in.nextInt();
            if(operate==1)set.add(x);
            else{
                int temp = 0;
                for(int i:set){
                    if((i|x)==x)temp|=i;
                    if(temp==x){
                        System.out.println("YES");
                        break;
                    }
                }
                if(temp!=x)System.out.println("NO");
            }
            q--;
        }
    }
}
