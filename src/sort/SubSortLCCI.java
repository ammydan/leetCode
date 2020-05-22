package sort;
/**
 * middle 面试题
 * 这是一个考虑排序本质的题目，而我一开始的思路是进行排序后再确定需要排序的range，但是提交后发现我的方法超时了。
 * 我需要找到一个时间复杂度为O(n)的算法，然后比较排序的复杂度的极限是O(nlogn)显然不行。
 * 参考了其他人的算法：
 * 核心就是一个数比左侧最大值大，比右侧最小值小那么这个数就无需排序。
 * 我们可以前后同时遍历，更新需要排序的范围。
 * ***/

public class SubSortLCCI {
    public int[] subSort(int[] array){
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        int len = array.length;
        int start=-1,end=-1;
        for(int i=0;i<len;i++){
            if(array[i]>=max)max = array[i];
            else end=i;
            if(array[len-i-1]<=min) min = array[len-i-1];
            else start=len-i-1;

        }
        int [] range = new int[2];
        range[0] = start;
        range[1] = end;
        return range;
    }
//    public int[] subSort(int[] array) {
//        int[] range = new int[2];
//        range[0] = -1;
//        range[1] = -1;
//        if(array.length<=1)return range;
//        int[] temp = array.clone();
//        mergeSort(array);
//        int min=-1,max=-1;
//        boolean flag= true;
//        for(int i=0;i<temp.length;i++){
//            if(array[i]!=temp[i]){
//                if(flag)min = i;
//                flag = false;
//                max = i;
//            }
//        }
//        range[0] = min;
//        range[1] = max;
//
//        return range;
//
//
//    }
//    private void swap(int[]array, int i, int j){
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }
//    private void merge(int[]array, int a, int b, int c){
//        int i = a;
//        int j = b;
//        int index = a;
//        int[] temp = array.clone();
//        while(index<c){
//            if(i>=b)array[index++] = temp[j++];
//            else if(j>=c) array[index++] = temp[i++];
//            else if(temp[i]>temp[j])array[index++] = temp[j++];
//            else array[index++] = temp[i++];
//        }
//    }
//    private void mergeSort(int[] array, int a, int b){
//        if(b-a>1){
//            int mid = a+(b-a)/2;
//            mergeSort(array,a,mid);
//            mergeSort(array,mid,b);
//            merge(array,a,mid,b);
//        }
//    }
//    private void mergeSort(int[] array){
//        mergeSort(array,0,array.length);
//    }
}
