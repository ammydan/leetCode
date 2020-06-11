package algorithm.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle2 {
    public List<Integer> generate(int rowIndex){
        List<Integer> list = new ArrayList<>();
        for(int j=0;j<rowIndex;j++){
            list.add(helper(rowIndex,j));
        }
        int[] hello = new int[4];
        Arrays.asList(hello);
        return list;
    }
    private int helper(int row, int col){
        if(col==0||row==col)return 1;
        return helper(row-1,col-1)+helper(row-1,col);
    }
}
