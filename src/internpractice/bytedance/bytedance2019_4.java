package internpractice.bytedance;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class bytedance2019_4 {
    public static class Pair {
        int x;
        int y;
        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Pair other = (Pair) obj;
            if(this.x==other.x&&this.y==other.y)return true;
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x,y);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        while(N>0){
            int M = in.nextInt();
            HashMap<Pair,Integer> previous = new HashMap<>();
            int max = 1;
            for(int i = 0;i<M;i++){
                HashSet<Pair> current = new HashSet<>();
                int nums = in.nextInt();
                nums*=2;
                for(int j=0;j<nums-1;j+=2){
                    Pair temp = new Pair(in.nextInt(),in.nextInt());
                    current.add(temp);
                }
                if(i>0) {
                    HashMap<Pair, Integer> newPrevious = new HashMap<>();
                    for (Pair p : current) {
                        if (previous.containsKey(p)) {
                            int val = previous.get(p)+1;
                            newPrevious.put(p, val);
                            max = max>val?max:val;
                        }
                        else newPrevious.put(p,1);
                    }
                    previous = newPrevious;
                }else{
                    for (Pair p:current) {
                        previous.put(p,1);
                    }
                }
            }
//            int max = 0;
//            for(int i : previous.values()){
//                max = max>i?max:i;
//            }
            System.out.println(max);
            N--;
        }
    }
}
