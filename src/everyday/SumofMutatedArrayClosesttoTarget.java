package everyday;

import java.util.ArrayList;
import java.util.Arrays;

/***
 * 1300 middle
 * 这道题其实有点让我摸不着头脑，完全不知道意义。
 * 1、自己的思路：
 * 首先avg = taget/arr.length,然后遍历arr统计，小于avg的和sum，然后用差值添加到avg。
 * 不过后面想了一下，感觉这样求出来的并不是最优的解。
 *
 * 2、参考思路
 * ①双重二分查找
 * 1)将数组进行排序
 * 2)记录下数组的求和
 * 3)因为value的增大，最终的结果是严格递增的，所以这里采用二分法进行查找。先寻找到value_lower，然后我们可以根据最终结果+1来获取value_upper.
 * **/
public class SumofMutatedArrayClosesttoTarget {
    public int findBestValue(int[] arr, int target){
        if(arr.length==0)return 0;
        if(arr.length==1)return target;
        Arrays.sort(arr);
        int [] previous = new int[arr.length];
        previous[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            previous[i] = previous[i-1]+arr[i];
        }
        int l=0, r=arr[arr.length-1];
        int valueLower=0;
        while(l<=r){
            int mid = (l+r)/2;
            int index = Arrays.binarySearch(arr,mid);
            if(index<0){
                index = -index-1;
            }
            int tempSum = previous[index-1]+(arr.length-index)*mid;
            if(tempSum<target){
                valueLower = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        int lowerSum = getSum(valueLower,arr);
        int upperSum = getSum(valueLower+1,arr);
        return Math.abs(lowerSum-target)<Math.abs(upperSum-target)?upperSum:lowerSum;


    }
    private int getSum(int value,int[] arr){
        int sum =0;
        for(int x:arr){
            sum+=Math.min(x,value);
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] arr = {2,5,5,5,7,7,7,8,12};
//        int index = Arrays.binarySearch(arr,6);
//        System.out.println(-index-1);
    }
}
