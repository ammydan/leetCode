package algorithm.doublePointers;

import java.util.HashMap;
/**
 * 76 hard
 * */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t){
        HashMap<Character, Integer> window , needed;
        window = new HashMap<>();
        needed = new HashMap<>();
        int lenS = s.length();
        int lenT = t.length();
        int start = 0;
        int len = Integer.MAX_VALUE;
        for(int i=0;i<lenT;i++){
            Character c = t.charAt(i);
            if(needed.containsKey(c)){
                needed.put(c,needed.get(c)+1);
            }else{
                needed.put(c,1);
            }
        }
        int left = 0, right=0, valid = 0;
        while(right<lenS){
            Character c = s.charAt(right);
            if(needed.containsKey(c)){
                if(window.containsKey(c)){
                    window.put(c,window.get(c)+1);
                }else{
                    window.put(c,1);
                }
                if(window.get(c).equals(needed.get(c)))valid++;
            }
            right++;
            while(valid==needed.size()){
                if(right-left<len){
                    start = left;
                    len = right-start;
                }
                Character cl = s.charAt(left);
                left++;
                if(window.containsKey(cl)){
                    window.put(cl,window.get(cl)-1);
                    if(window.get(cl).compareTo(needed.get(cl))<0)valid--;
                }
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring test = new MinimumWindowSubstring();
        test.minWindow("ADOBECODEBANC","ABC");
    }
}
