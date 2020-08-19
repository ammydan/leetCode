package internpractice.Netease;

import java.util.HashMap;
import java.util.Scanner;

public class Netease2020_8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        HashMap<Integer,Integer> record = new HashMap<>();
        for(int i=0;i<n;i++){
            int salary = in.nextInt();
            if(record.containsKey(salary)){
                record.put(salary,record.get(salary)+1);
            }else{
                record.put(salary,1);
            }
        }
        for(int i=0;i<m;i++){
            int query = in.nextInt();
            Integer ans = record.get(query);
            if(ans==null)System.out.println(0);
            else System.out.println(ans);
        }
    }
}
