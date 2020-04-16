package easy;

import java.util.Stack;
/**
 * stack:使用的问题
 *
 * */

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack stack = new Stack<Character>();
        int len = s.length();
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            switch(c){
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.empty()) return false;
                    char temp1 = (char) stack.pop();
                    if(temp1!='(')return false;
                    break;
                case ']':
                    if(stack.empty()) return false;
                    char temp2 = (char)stack.pop();
                    if(temp2!='[')return false;
                    break;
                case '}':
                    if(stack.empty()) return false;
                    char temp3 = (char)stack.pop();
                    if(temp3!='{')return false;
                    break;
            }
        }
        if(stack.empty())return true;
        else return false;


    }
}
