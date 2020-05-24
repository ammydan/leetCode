package sort;

import java.util.Set;
import java.util.TreeSet;

/****
 * middle 面试题
 * 这里需要掌握一个简单的数学计算的技巧。否则采用排序再使用双指针查找相应的元素会慢上许多。
 * 时间复杂度：O(n)
 * **/

public class SumSwapLCCI {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1=0,sum2=0;
        Set<Integer> set2 = new TreeSet<>();
        for(int i: array1){
            sum1+=i;
        }
        for(int i: array2){
            sum2+=i;
            set2.add(i);
        }
        int diff = sum1-sum2;
        if(diff%2!=0)return new int[0];
        for(int i: array1){
            if(set2.contains(i-diff/2)){
                int[] ans = new int[2];
                ans[0] = i;
                ans[1] = i-diff/2;
                return ans;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int i = -1;
        int [] test = new int[0];
        System.out.println(i%2);
        System.out.println(test.toString());
    }

}
