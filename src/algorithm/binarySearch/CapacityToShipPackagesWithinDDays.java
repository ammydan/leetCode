package algorithm.binarySearch;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int D){
        int len = weights.length;
        int sum = 0, low=0, high = 0;
        for(int i=0;i<len;i++){
            sum+=weights[i];
        }
        low = sum/D;
        high = sum;
        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(canShip(weights,mid,D)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    private boolean canShip(int[] weights, int capacity,int D){
        int sum = 0;
        int times = 0;
        for(int n: weights){
            if(n>capacity)return false;
            if(sum+n<capacity){
                sum+=n;
            }else if( sum+n==capacity){
                sum = 0;
                times++;
            }else{
                sum = n;
                times++;
            }
        }
        if(sum>0)times++;
        if(times<=D) return true;
        return false;
    }

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays test = new CapacityToShipPackagesWithinDDays();
        int[] list = {1,2,3,4,5,6,7,8,9,10};
        test.shipWithinDays(list,5);
    }
}
