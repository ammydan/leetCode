package algorithm.recursive;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> generate(int numRows){
        for(int i=0;i<numRows;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<=i;j++){
                list.add(helper(i,j));
            }
            ans.add(list);
        }
        return ans;
    }
    private int helper(int row, int col){
        if(col==0||row==col)return 1;
        if(ans.get(row-1)!=null)return ans.get(row-1).get(col-1)+ans.get(row-1).get(col);
        return helper(row-1,col-1)+helper(row-1,col);
    }
}
