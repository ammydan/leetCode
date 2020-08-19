package everyday;

import java.util.LinkedList;
/**
 *Easy 剑指Offer
 * 这道题当初被教授当作amort算法分析来讲，很简单。
 * 时间复杂度：均摊为O(1)
 * 空间复杂度：O(n)
 * */
public class TwoStackImplQueue {
    private LinkedList<Integer> stackIn ;
    private LinkedList<Integer> stackOut ;
    public TwoStackImplQueue(){
        stackIn  = new LinkedList<>();
        stackOut = new LinkedList<>();
    }
    public void appendTail(int value){
        stackIn.push(value);
    }

    public int deleteHead(){
        if(!stackOut.isEmpty())return stackOut.pop();
        while(!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
        if(!stackOut.isEmpty())return stackOut.pop();
        return -1;
    }
}
