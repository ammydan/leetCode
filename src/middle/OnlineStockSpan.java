package middle;

import java.util.LinkedList;

/**
 * midlle 901
 * 单调栈练习
 * */
public class OnlineStockSpan {
    private LinkedList<int[]> stack ;
    private int index;

    public OnlineStockSpan(){
        stack = new LinkedList<>();
        stack.add(new int[]{0,Integer.MAX_VALUE});
        index = 1;
    }
    public int next(int price){
        while(stack.peekFirst()[1]<=price){
            stack.pop();
        }
        int[] values = stack.peekFirst();
        int ans = index-values[0];
        stack.push(new int[]{index,price});
        index++;
        return ans;
    }
}
