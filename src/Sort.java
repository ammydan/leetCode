import java.util.LinkedList;

public class Sort {
    private Boolean less(Comparable a, Comparable b){
        if(a.compareTo(b)<0) return true;
        return false;
    }
    private void swap(Comparable[] list, int i, int j){
        Comparable temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
    /***
     * Sort1: BubbleSort
     * Runtime Complexity:O(n^2)
     * Space Complexity:O(1)
     * 排序方式：inplace
     * 稳定性：稳定stable
     * 1、从第一个元素开始与临近的后面一个元素做比较（并用一个指针或者索引进行位置确定）：
     *  1)如果大于后面一个元素，则与后面的元素换位置指针+1
     *  2)如果等于直接指针+1
     * 2、重复1步骤直到到达最后一个元素
     * (我们观察这个算法，发现无论临近的两个元素谁大，我们都需要推进指针，所以我们可以直接使用循环。
     * **/
    public void bubbleSort(Comparable[] list){
        int len = list.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(less(list[j],list[i])){
                    swap(list,i,j);
                }
            }
        }
    }

    /***
     * Sort2: SelectionSort
     * Runtime Complexity: O(n^2)
     * Space Complexity: O(1)
     * 排序方式：inplace
     * 稳定性：不稳定unstable
     * 1、首先选择列表中最小/大的元素（记录这个最大元素的位置，而不是其值），将其与第一个位置元素交换
     * 2、接着在剩下的所有的再重复1的步骤，直到最后一个元素
     * ****/
    public void selectionSort(Comparable[] list){
        int len = list.length;
        for(int i=0;i<len-1;i++){
            int minPoint = i;
            for(int j=i+1;j<len;j++){
                if(less(list[j],list[minPoint])){
                    minPoint = j;
                }
            }
            swap(list,i,minPoint);
        }
    }

    /**
     * Sort3: InsertionSort
     * Rutime
     * 1、将分为两个部分，前面一个部分是已经排好序的，后面是未排序的。
     * 2、选择后面部分的第一个元素，在前面部分找到一个合适的位置然后插入（并入前面的部分）
     * 3、重复1，2步骤直到后面部分没有元素了
     * ***/
    public void insertionSort(Comparable[] list){
        int len = list.length;
       for(int i=1;i<len-1;i++){
           for(int j=i+1;i<len;j++){

           }
       }
    }

    public static void main(String[] args) {
        Sort test = new Sort();
        Integer[] list = {4,3,7,1,33,23};
        test.selectionSort(list);
        for(int i :list){
            System.out.println(i);
        }
    }
}
