package algorithm.prime;

import java.util.Arrays;

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes){
        long[] record = new long[n+1];
        record[1] = 1;
        int len = primes.length;
        int[] index = new int[len];
        Arrays.fill(index,1);
        for(int i=2;i<=n;i++){
            long min = Integer.MAX_VALUE;
            for(int j=0;j<len;j++){
                min = Math.min(record[index[j]]*primes[j],min);
            }
            record[i] = min;
            for(int j=0;j<len;j++){
                if(min==record[index[j]]*primes[j])index[j]++;
            }
        }
        return (int)record[n];
    }
}
