package algorithm.binarySearch;

import algorithm.subString.KMP;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H){
        int len = piles.length;
        int sum=0,low=0, high = 0;
        for(int i =0;i<len;i++){
            sum+=piles[i];
            high = Math.max(high,piles[i]);
        }
        low = sum/H;
        int mid = 0;
        while(low<high){
            mid = low+(high-low)/2;
            if(canFinish(piles,mid,H)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    private boolean canFinish(int []piles, int speed,int H){
        int time = 0;
        for(int n: piles){
            time += timeOf(n, speed);
        }
        return time<=H;
    }
    int timeOf(int n, int speed){
        return (n/speed)+((n%speed>0)?1:0);
    }

    public static void main(String[] args) {
        KokoEatingBananas test = new KokoEatingBananas();
        int [] piles = {3,6,7,11};
        test.minEatingSpeed(piles,8);
    }
}
