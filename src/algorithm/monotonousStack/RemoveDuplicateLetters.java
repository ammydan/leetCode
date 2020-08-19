package algorithm.monotonousStack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s){
        int len = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            Character c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        LinkedList<Character> stack = new LinkedList<>();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i<len;i++){
            Character c = s.charAt(i);
            if(set.contains(c)){
                map.put(c,map.get(c)-1);
                continue;
            }
            while(!stack.isEmpty()&&c<stack.peekLast()&&map.get(stack.peekLast())>0){
                Character temp = stack.pollLast();
//                map.put(temp,map.get(temp)-1);
                set.remove(temp);
            }
            stack.add(c);
            map.put(c,map.get(c)-1);
            set.add(c);
        }
        StringBuilder ans = new StringBuilder();
        for(char c: stack){
            ans.append(c);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters test = new RemoveDuplicateLetters();
        test.removeDuplicateLetters("edebbed");
    }
}
