package algorithm.prime;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 264 middle
 *
 * */
public class UglyNumber2 {
//    自己这个方法太笨了。
//    HashSet<Integer> set = new HashSet<>();
//    int []record ;
//    public int nthUglyNumber(int n){
//        if(n==1)return 1;
//        if(n==2)return 2;
//        if(n==3)return 3;
//        if(n==4) return 4;
//        if(n==5) return 5;
//        set.add(1);
//        set.add(2);
//        set.add(3);
//        set.add(4);
//        set.add(5);
//        int[] record = new int[n+1];
//        record[1] = 1;
//        record[2] = 2;
//        record[3] = 3;
//        record[4] = 4;
//        record[5] = 5;
//        for(int i=5;i<=n;i++){
//            for(int j=record[i-1]+1;;j++){
//                if(isUgly(j)){
//                    record[i] = j;
//                    break;
//                }
//            }
//        }
//        return record[n];
//
//    }
//    private boolean isUgly(int x){
//        if(set.contains(x))return true;
//        boolean flag = false;
//        if(x%2==0)flag = isUgly(x/2);
//        else if(x%3==0)flag =  isUgly(x/3);
//        else if(x%5==0)flag =  isUgly(x/5);
//        if(flag)set.add(x);
//        return flag;
//
//    }
//    1、大小堆
    public int nthUglyNumber(int n){
//        PriorityQueue<Long> pq = new PriorityQueue<>();
//        HashSet<Long> set = new HashSet<>();
//        pq.add(1L);
//        long[] record = new long[n+1];
//        for(int i=1;i<=n;i++){
//            long temp = pq.remove();
//            while(set.contains(temp))temp = pq.remove();
//            set.add(temp);
//            record[i] =temp;
//            pq.add(record[i]*2);
//            pq.add(record[i]*3);
//            pq.add(record[i]*5);
//        }
//        return (int) record[n];
//        2、DP
        long[] record = new long[n+1];
        record[1] = 1;
        int index2 = 1;
        int index3 = 1;
        int index5 = 1;
        for(int i=2;i<=n;i++){
            record[i] = Math.min(record[index2]*2,record[index3]*3);
            record[i] = Math.min(record[i],record[index5]*5);
            if(record[i]==record[index2]*2)index2++;
            if(record[i]==record[index3]*3)index3++;
            if (record[i]==record[index5]*5)index5++;

        }
        return (int)record[n];

    }


    public static void main(String[] args) {
        UglyNumber2 test = new UglyNumber2();
        test.nthUglyNumber(10);
    }
}
