package dataStructure;

/**
 * https://blog.csdn.net/flushhip/article/details/79165701
 * 树状数组(没有初始化的sum数组)
 * 1、操作：
 * ①修改固定大小数组的值O(logn)
 * ②获取区间范围的大小O(logn)
 * */
public class ArrayTree {
    int[] sum;
    int n;
    public ArrayTree(int n){
        sum = new int[n+1];
        this.n = n;
    }
// lowbit是求一个数1的最低位。
    private int lowbit(int x){
        return x& -x;
    }
//    直接加上了相应的value。
    public void update(int index,int value){
        int x = index;
        while(x<=n){
            sum[x] +=value;
            x+=lowbit(x);
        }
    }
    public int rangeSum(int left,int right){
        int leftSum = 0;
        int x = left;
        while(x>0){
            leftSum += sum[x];
            x-=lowbit(x);
        }
        int rightSum = 0;
        x = right;
        while(x>0){
            rightSum += sum[x];
            x-=lowbit(x);
        }
        return rightSum-leftSum;
    }

}
