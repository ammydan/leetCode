package everyday;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.TreeSet;

public class ReSpaceLCCI {
    public int respace(String[] dictionary, String sentence){
        int len = sentence.length();
        if(len==0)return 0;
        TreeSet<String> set = new TreeSet<>();
        for(String str: dictionary){
            set.add(str);
        }
        int []opt = new int[len];
        int ans = 0;
        for(int i=0;i<len;i++){
            if(i>0)opt[i] = Math.max(opt[i],opt[i-1]);
            for(int j=i;j<len;j++){
                int temp = 0;
                if(set.contains(sentence.substring(i,j+1)))temp = j-i+1;
                if(i>0){
                    opt[j] = Math.max(opt[j],opt[i-1]+temp);
                }else opt[j] = temp;
                ans = Math.max(ans,opt[j]);
            }
        }
        return len-ans;
    }
    private boolean lookUp(String[] dictionary, String word){
        for(String str: dictionary){
            if(word.equals(str))return true;
        }
        return false;
    }
}
