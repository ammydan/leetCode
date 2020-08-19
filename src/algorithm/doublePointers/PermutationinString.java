package algorithm.doublePointers;

import java.util.HashMap;
/**
 * middle 567
 * */
public class PermutationinString {
    public boolean checkInclusion(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        int left = 0, right = 0;
        HashMap<Character,Integer> needed, window;
        needed = new HashMap<>();
        window = new HashMap<>();
        for(int i=0;i<len1;i++){
            Character c = s1.charAt(i);
            needed.put(c,needed.getOrDefault(c,0)+1);
        }
        int valid = 0;
        while(right<len2){
            Character c = s2.charAt(right);
            right++;
            if(needed.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(needed.get(c)))valid++;
            }
            while(valid==needed.size()){
                if(right-left==len1)return true;
                Character cl = s2.charAt(left);
                left++;
                if(window.containsKey(cl)){
                    window.put(cl,window.get(cl)-1);
                    if (window.get(cl).compareTo(needed.get(cl))<0)valid--;
                }
            }
        }
        return false;
    }
}
