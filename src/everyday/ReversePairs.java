package everyday;

import dataStructure.ArrayTree;

import java.util.Arrays;

/**
 *hard 剑指offer 数组的逆序对。
 * 1、自己的思路
 * 开始仅仅只有一个念头就是暴力破解，O(n^2)按理说也算比较好的了。但是看看这是道hard题目，肯定要O(nlogn)或以下。
 * O(n)想想也不可能。看到logn觉得肯定与顺序有关系，有一定的技巧。
 * 2、参考思路
 * ①归并
 * 在合并的时候进行处理，当左右两侧进行比较的时候，如果右侧小于左侧则必定存在一对逆序对，那么我们需要记录下来。
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 * ②离散化树状数组
 *
 * **/
public class ReversePairs {
//    private int count;
//    private int[] temp;
//    public int reversePairs(int[] nums){
//        int len = nums.length;
//        if(len<=1)return 0;
//        temp = new int[len];
//        sort(nums,0,len);
//        return count;
//    }
//    private void sort(int[] nums, int left, int right){
//        if(right-left>1){
//            int mid = left+(right-left)/2;
//            sort(nums,left,mid);
//            sort(nums,mid,right);
//            if(nums[mid-1]<=nums[mid]) return;
//            merge(nums,left,mid,mid,right);
//        }
//    }
//    private void merge(int[] nums, int l1, int r1, int l2, int r2){
//        int i = l1, j = l2,k = l1;
//        for(int n=l1;n<r2;n++){
//            temp[n] = nums[n];
//        }
//        while(k<r2){
//            if(i>=r1) nums[k++] = temp[j++];
//            else if(j>=r2) {
//                count+=(r2-l2);
//                nums[k++] = temp[i++];
//            }
//            else if(temp[j]<temp[i]){
//                nums[k++] = temp[j++];
//            }else {
//                count = count+j-l2;
//                nums[k++] = temp[i++];
//            }
//        }
//    }
    private int count[];
    private int lowbit(int x){
        return x&-x;
    }
    private void update(int index){
        int len = count.length;
        while(index<len){
            count[index]+=1;
            index += lowbit(index);
        }
    }
    private int query(int index){
        int sum = 0;
        while(index>0){
            sum+=count[index];
            index-=lowbit(index);
        }
        return sum;
    }
    public int reversePairs(int[] nums){
        int len = nums.length;
        if(len<2) return 0;
        count = new int[len+1];
        int[] list = nums.clone();
        int [] indexes = new int[len];
        int ans = 0;
        Arrays.sort(list);
        for(int i = 0;i<len;i++){
             indexes[i] = Arrays.binarySearch(list,nums[i])+1;
        }
        for(int i=len-1;i>=0;i--){
            ans+=query(indexes[i]-1);
            update(indexes[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        ReversePairs test = new ReversePairs();
//        int[] list = {4,5,6,7};
//        int[] list = {7,5,6,4};
//        int [] list = {1,3,2,3,1};
        int [] list = {2,4,3,5,1};
        test.reversePairs(list);

    }
}
