package middle;

import java.util.LinkedList;
/**
 * middle 402
 * 单调栈练习，关键要掌握相对位置不变，以及结果的位数确定。
 * */
public class RemoveKDigits {
    public String removeKdigits(String num, int k){
        LinkedList<Character> stack = new LinkedList<>();
        stack.add('0');
        int len = num.length();
        if(len<=k)return "0";
        for(int i =0;i<len;i++){
            if(k==0){
                stack.push(num.charAt(i));
                continue;
            }
            while(k>0&&stack.peekFirst().compareTo(num.charAt(i))>0){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        for(int i = 0;i<k;i++){
            stack.pop();
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()&&stack.peekLast().compareTo('0')==0) stack.pollLast();
        len = stack.size();
        for(int i=0;i<len;i++){
            ans.append(stack.pollLast());
        }
        if(ans.length()==0)ans.append("0");
        return ans.toString();
//        LinkedList<Character>stack  = new LinkedList<>();
//        int len = num.length();
//        int start =-1;
//        for(int i=0;i<len;i++){
//            Character c = num.charAt(i);
//            while(!stack.isEmpty()&&stack.peekLast()>c){
//                stack.pollLast();
//                k--;
//                if(k==0){
//                    start = i;
//                    break;
//                }
//            }
//            if(k==0)break;
//            stack.add(c);
//        }
//        StringBuilder ans = new StringBuilder();
//        for(Character c: stack){
//            ans.append(c);
//        }
//        if(start!=-1) {
//            for(int i=start;i<len;i++){
//                ans.append(num.charAt(i));
//            }
//        }
//        String str = ans.toString();
//        str = str.replaceAll("^(0+)","");
//        if(str.isEmpty())str = "0";
//        return str;
    }

    public static void main(String[] args) {
        RemoveKDigits test = new RemoveKDigits();
        test.removeKdigits("10",2);
    }
}
