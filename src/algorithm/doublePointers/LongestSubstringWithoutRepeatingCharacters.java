package algorithm.doublePointers;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s){
        int len = s.length();
        HashSet<Character> window = new HashSet<>();
        int left = 0, right = 0,ans=0;
        boolean valid = false;
        Character temp = null;
        while(right<len){
            Character c = s.charAt(right);
            right++;
            if(window.contains(c)){
                valid = true;
                temp = c;
            }else{
                window.add(c);
                ans = ans>window.size()?ans:window.size();
            }
            while(valid){
                Character cl = s.charAt(left);
                left++;
                if(cl.equals(temp)){
                    valid = false;
                    continue;
                }
                window.remove(cl);
            }
        }
        return ans;
    }
}
