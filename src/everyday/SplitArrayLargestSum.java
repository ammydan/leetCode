package everyday;
/**
 * 410 hard
 * 类似hard 1478
 * 1、自己的想法
 * 一开始想着让最大sum最小，那么每组都尽可能地均匀，否则sum可能会变得很大。（其实这个想法是错误的，可能前面几个数字都很小，加起来也没有后面的一个数大
 * */
public class SplitArrayLargestSum {
    public int splitArray(int[]nums, int m){
//        1、动态规划
//        int len = nums.length;
//        int[][] opt = new int[len+1][m+1];
//        int []sum = new int[len+1];
//        for(int i=1;i<len;i++){
//            sum[i] = sum[i-1]+nums[i-1];
//        }
//        for(int i=1;i<=len;i++){
//            for(int j=1;j<=m;j++){
//                for(int k=j-1;k<i;k++){
//                    opt[i][j] = Math.min(opt[i][j],Math.max(opt[k][j-1],sum[i]-sum[k]));
//                }
//            }
//        }
//        return opt[len][m];
//        2、二分法+贪心算法
        int high = 0, low = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            low = Math.max(nums[i],low);
            high+=nums[i];
        }
        int mid = 0;
        while(low<high){
            mid = low+(high-low)/2;
            if(valid(nums,m,mid)){
                high = mid;
            }else low = mid+1;
        }
        return low;
    }
    private boolean valid(int[]nums, int m,int mid){
        int cnt = 1;
        int temp = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]+temp>mid){
                cnt++;
                temp = nums[i];
            }else{
                temp+=nums[i];
            }
        }
        return cnt<=m;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum test = new SplitArrayLargestSum();
        int[] nums = {7,2,5,10,8};
        test.splitArray(nums,2);
    }
}
