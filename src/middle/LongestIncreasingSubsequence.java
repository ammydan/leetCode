package middle;

import java.util.Arrays;

/***
 * 300. Longest Increasing Subsequence
 * 方法一：动态规划。
 * 我们一开始会很容易自然而然地想到最优子数组的连续递增数与增加一个的比较。
 * 但是这里有一个问题就是我们无法知道该子数组的递增子序列的最后一个元素是什么。
 * 因此我们第一个猜想就无法执行。
 * 接着我们的第二个猜想：既然我们一定要知道最后一个子序列的大小，那我们干脆假设opt[i]是以i结尾的
 * 子序列的最大值。这样我们就可以得到一个转移方程：
 * if(nums[j]<nums[i])
 *  opt[i] = max(opt[j]+1,opt[i])
 * 这里我们需要比较所有i以前的子序列，因为我们并不知道哪一个加上这个元素可以得到以i结尾的元素最优。
 * 而且这中间我们是保留了以某个特殊位置的元素结尾最优所以整个数组最优解应该还需要一个max来记录。
 * 初始化：
 * for all i
 * nums[i]=1
 * 时间复杂度:O(n^2)
 *
 * 方法二：贪心算法+二分查找
 * 我们用tail[i]记录的是长度为i的子序列的最小结尾数值。
 * 最终返回的结果是tail的长度。
 * 时间复杂度：O(nlogn)
 * ***/
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<1)return 0;
        if(nums.length<2) return 1;
//        int[] opt = new int[nums.length];
//        Arrays.fill(opt,1);
//        int max = 0;
//        for(int i=1;i<nums.length;i++){
//            for(int j=0;j<i;j++){
//                if(nums[i]>nums[j])opt[i] = Math.max(opt[i],opt[j]+1);
//            }
//            if(max<opt[i]) max = opt[i];
//        }
//        return max;
        int len = nums.length;
        int[] tail = new int[len];
        tail[0] = nums[0];
        int j = 0;
        for(int i=0;i<len;i++){
            if(nums[i]>tail[j])tail[++j] = nums[i];
            else{
                tail[binarySearch(tail,nums[i],0,j)]=nums[i];
            }
        }
        System.out.println(nums[j]);
        return j+1;
    }
    /**
     * 这里有一个binarySearch的基本技术总结：
     * 1、我们自己实现binarySearch的时候需要左右l,r都是合法可取值的范围，而不是像数组一样可取值范围为r-1。
     * 2、mid的计算(l+r)/2。
     * 3、循环跳出的条件一定要为l<=r不可以漏掉等号。
     * 4、不相等的时候l=mid+1或者r=mid-1。
     * 5、我们跳出循环的时候，mid不一定就是我们需要的值，所以我们需要进行判断，mid是否是我们寻找的值，如果不是的话就返回未找到的信号。
     *
     * 6、我们改编binarySearch进行适宜位置查询时，如果我们需要找到的是要尽可能贴近value且比value小的值时，可以在array[mid]<value时pos=mid。反之亦然。
     * 我们的Arrays.binarySearch(array,value)如果没有找到相应的值，就会返回要插入的位置，-index-1，返回的是较大的那一个位置。
     * Collections.binarySearch(array,value)也同理。
     * Arrays.binarySearch(array,l,r,value)全部为实际的大小。
     * ***/
    private int binarySearch(int[] array,int value,int l,int r){
        int pos = 0;
        while(l<=r){
            int mid = (l+r)/2;
            if(array[mid]==value){
                pos = mid;
                break;
            }else if(array[mid]>value){
                pos = mid;
                r = mid-1;
            }else{
                l = mid +1;
            }
        }
        return pos;

    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence test = new LongestIncreasingSubsequence();
//        int[] nums={1,3,6,7,9,4,10,5,6};
//        int[] nums={10,9,2,5,3,7,101,18};
//        int[] nums={4,10,4,3,8,9};
        int[] nums={2,2};
        int ans = test.lengthOfLIS(nums);
        System.out.println(ans);

    }
}
