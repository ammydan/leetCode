package hard;

import java.util.LinkedList;
/**
 * 84 hard
 * 1、自己的想法
 * 自己想着想着直接误入歧途，以为就是类似于最大连续子数组的DP，然后发现其实中途断开不会实时发现最大值。对于最大连续子数组
 * 如果断开联系那么就完全和前面没有了联系了，这个却依然有着千丝万缕的联系（转移方程状态个数不确定）。
 *
 *2、参考方法
 * ①单调栈
 * 1)当栈顶遇到后面添加的值比自己小的时候，这时以自己为高度的面积（且包含自己的位置）计算已经截止了，那么我们就开始计算这个面积。
 * 并且与以前计算的max进行比较。（要注意可能会有多个值要计算）
 * 2)当新加入的值和自己一样大或者比自己更大的时候直接放入栈中。
 * ②单调栈升级：加入哨兵
 * 首尾加上一个为0的哨兵。
 * */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights){
        int len = heights.length;
        if(len==0) return 0;
        if(len==1)return heights[0];
        LinkedList<Integer> stack = new LinkedList<>();
        int[] list= new int[len+2];
        list[0] = list[len+1]= -1;
        for(int i=1;i<=len;i++){
            list[i] = heights[i-1];
        }
        int ans = 0;
        for(int i=0;i<=len+1;i++){
            while(!stack.isEmpty()&&list[i]<list[stack.peek()]){
                int l = i;
                int height = list[stack.pop()];
                int r = stack.peek();
                int area = (l-r-1)*height;
                ans = ans>area? ans:area;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestRectangleinHistogram test = new LargestRectangleinHistogram();
        int[] list = {1,0,1,0,1};
        test.largestRectangleArea(list);
    }
}
