package middle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for(String str: wordDict){
            dict.add(str);
        }
        int len = s.length();
        s = " "+s;
        boolean[] f = new boolean[len+1];
        f[0] = true;
        for(int i=1;i<=len;i++){
            for(int j=0;j<i;j++){
                if(f[j]){
                    String temp = s.substring(j+1,i+1);
                    if(dict.contains(temp)){
                        f[i]=true;
                        break;
                    }
                }
            }
        }
        return  f[len];
    }

    public static void main(String[] args) {
        String str = "leetcode";
        List<String> wordDict = new LinkedList<>();
        wordDict.add("leet");
        wordDict.add("code");
        WordBreak test = new WordBreak();
        System.out.println(test.wordBreak(str,wordDict));
    }
}
