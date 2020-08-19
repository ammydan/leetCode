package everyday;

import java.util.LinkedList;

public class LongestValidParenthese {
    public int longestValidParentheses(String s){
//        1、自己的方法（没什么技巧，就是记录并模仿，做了分类）
//        LinkedList<Character> stack = new LinkedList<>();
//        LinkedList<int[]> list = new LinkedList<>();
//        int max = 0;
//        int index = 0, len = s.length();
//        while(index<len){
//            int tempNum = 0;
//            if(s.charAt(index)=='('){
//                stack.push('(');
//                index++;
//            }
//            else{
//                if(stack.isEmpty()){
//                    list.clear();
//                    index++;
//                    continue;
//                }
//                while(!stack.isEmpty()&&index<len&&s.charAt(index)==')'){
//                    stack.pop();
//                    tempNum+=2;
//                    index++;
//                }
//                int tempSize = stack.size();
//                while(!list.isEmpty()&&tempSize<=list.peek()[0]){
//                    tempNum += list.pop()[1];
//                }
//                max = max<tempNum?tempNum:max;
//                list.push(new int[]{tempSize,tempNum});
//            }
//        }
//        return max;
//        2、参考思路：动态规划
//        int len = s.length();
//        int[] opt = new int[len];
//        int max = 0;
//        for(int i=1;i<len;i++){
//            if(s.charAt(i)==')'){
//                if(s.charAt(i-1)=='('){
//                    opt[i] = (i-2>=0?opt[i-2]:0)+2;
//                }else if(i-opt[i-1]>0&&s.charAt(i-opt[i-1]-1)=='('){
//                    opt[i] = opt[i-1]+((i-opt[i-1])>=2?opt[i-opt[i-1]-2]:0)+2;
//                }
//                max = Math.max(max,opt[i]);
//            }
//        }
//        return max;
//        3、参考思路：堆栈
        LinkedList<Integer> stack = new LinkedList<>();
        int max = 0;
        stack.push(-1);
        int len = s.length();
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='(')stack.push(i);
            else{
                int temp=0;
                if(stack.size()>0) stack.pop();
                if(stack.size()>0) temp = i-stack.peek();
                else stack.push(i);
                max = Math.max(temp,max);
            }
        }
        return max;
//        4、正序和逆序结合

    }

    public static void main(String[] args) {
        LongestValidParenthese test = new LongestValidParenthese();
        test.longestValidParentheses(")()())");
    }
}
