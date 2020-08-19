package contest.contest20200621;

import dataStructure.UnionFind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class UniqueFileName {
    public String[] getFolderNames(String[] names){
        HashMap<String,Integer> table = new HashMap<>();
        String[] ans = new String[names.length];
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<names.length;i++){
            String temp = names[i];
            String str = temp;
            while(table.containsKey(str)){
                int n = table.get(temp);
                str = helper(temp,n);
                table.put(temp,n+1);
            }

            if(str.equals(temp)){
                table.put(temp,1);
            }
            while(set.contains(str)){
                int n = table.get(temp);
                str = helper(temp,n);
                table.put(temp,n+1);
            }
            ans[i] = str;
            set.add(str);
        }
        return ans;
    }
    private String helper(String str, int i){
        return str+"("+i+")";
    }

    public static void main(String[] args) {
        UniqueFileName test = new UniqueFileName();
        String[] str = {"gta","gta(1)","gta","avalon"};
//        String[] str = {"kaido","kaido(1)","kaido","kaido(1)"};
//        String[] str = {"kaido","kaido(1)","kaido","kaido(1)","kaido(2)"};
        str = test.getFolderNames(str);
        System.out.println(Arrays.toString(str));
    }
}
