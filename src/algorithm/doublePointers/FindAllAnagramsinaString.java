package algorithm.doublePointers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/**
 * 438 middle
 * */
public class FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p){
        int lenS = s.length();
        int lenP = p.length();
        HashMap<Character, Integer> needed, window;
        needed = new HashMap<>();
        window = new HashMap<>();
        for(int i=0;i<lenP;i++){
            Character c = p.charAt(i);
            needed.put(c,needed.getOrDefault(c,0)+1);
        }
        int left = 0,right=0,valid=0;
        LinkedList<Integer> ans = new LinkedList<>();
        while(right<lenS){
            Character c = s.charAt(right);
            right++;
            if(needed.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(needed.get(c)))valid++;
            }
            while(valid==needed.size()){
                if(right-left==lenP)ans.add(left);
                Character cl = s.charAt(left);
                left++;
                if(window.containsKey(cl)){
                    window.put(cl,window.get(cl)-1);
                    if(window.get(cl).compareTo(needed.get(cl))<0)valid--;
                }
            }
        }
        return ans;
    }
}
