package algorithm.prime;

import java.util.Arrays;
/**
 *204 easy
 * 快速计算素数。
 * */
public class CountPrimes {
    public int countPrimes(int n){
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes,true);
        for(int i=2;i*i<n;i++){
            if(isPrimes[i]){
                for(int j=i*i;j<n;j+=i){
                    isPrimes[i] = false;
                }
            }
        }
        int num = 0;
        for(int i=2;i<n;i++){
            if(isPrimes[i])num++;
        }
        return num;
    }
}
