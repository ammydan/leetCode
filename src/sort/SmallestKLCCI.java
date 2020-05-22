package sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/***
 * middle 面试题
 * 这道题只是要我们找到前k个大的数字。
 * 暴力破解的方式：先排序，后选区前K个数字O(nlogn)
 * 大小堆方法：将数组丢入大小堆中，然后从堆中删除K个数字O(n+klogn)在k小于n的时候这个算法可以提高效率
 *参考方法：quicksort改编版，这个的复杂度不确定，很依赖输入的数组，所以不是特别推荐。
 * **/

public class SmallestKLCCI {
    public int[] smallestK(int[] arr, int k) {
        Integer[] arrI = new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            arrI[i] = arr[i];
        }
        PriorityQueue<Integer>pq = new PriorityQueue<>(Arrays.asList(arrI));
        int[]ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
}
