package sort;

import java.util.List;

/**
 * 524 middle
 * Longest Word in Dictionary through Deleting
 * 解法：这道题就是普通的暴力解决方法，没有涉及到sort的算法，差评。
 * **/
public class FindLongestWord {
    public String findLongestWord(String s, List<String> d) {
        String strMax = "";
        for(String str: d){
            for(int i=0,j=0;i<s.length();i++){
                if(s.charAt(i)==str.charAt(j))j++;
                if(j>=str.length()){
                    if(j>strMax.length()||(str.length()==strMax.length()&&str.compareTo(strMax)>0))strMax=str;
                    break;
                }
            }
        }
        return strMax;
    }
}
