package everyday;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * middle 739
 * 这里只想到了暴力破解的方法。
 *
 * 参考：
 * 1、温度的范围比较小，可以考虑直接按温度来遍历计算：
 * ①用一个数组，index记录温度，temp[index]记录温度所在的序号。（初始化为无穷大）
 * ②我们反向遍历原来的温度数组，更新temp要记录的序号，并且也要找寻最近的序号。
 * ③我们可以注意到，其实可能出现多个相同的温度，但是我们是逆序的遍历，最终记录下来的是相同温度下，最小的index。
 * 时间复杂度O(NM)，其中M是温度的范围。
 * 空间复杂度O(M)，我们需要额外的数组记录下温度所在的序号。
 *
 * 2、单调栈
 * ①维护一个栈，栈从底部到顶部，温度依次下降。
 * ②遍历题目所给的温度的时候，如果当前温度大于栈顶温度，则弹出栈顶，并且更新ans。一直弹出直到问题
 * 判断是否需要单调栈：找一个数左侧或者右侧第一个比其大/小的数。
 * **/
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T){
//        int[] tmp = new int[101];
//        int [] ans = new int[T.length];
//        Arrays.fill(tmp,Integer.MAX_VALUE);
//        for(int i=T.length-1; i>=0;i--){
//            int minIndex = Integer.MAX_VALUE;
//            for(int j=i+1;j<=100;j++){
//                if(tmp[j]<minIndex){
//                    minIndex = tmp[j];
//                }
//            }
//            if(minIndex<Integer.MAX_VALUE){
//                ans[i] = minIndex-i;
//            }
//            tmp[T[i]] = i;
//        }
//        return ans;
        int[] ans = new int[T.length];
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        for(int i=1;i<T.length;i++){
            while(!stack.isEmpty()&&T[stack.peek()]<T[i]){
                int index = stack.pop();
                ans[index] = i-index;
            }
            stack.push(i);
        }
        return ans;

    }
}
