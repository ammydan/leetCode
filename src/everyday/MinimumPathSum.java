package everyday;

import java.util.Arrays;

public class MinimumPathSum {
    public int minPathSum(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        int[] opt = new int[cols+1];
        Arrays.fill(opt,Integer.MAX_VALUE);
        opt[1] = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                opt[j+1] = Math.min(opt[j],opt[j+1])+grid[i][j];
            }
        }
        return opt[cols];
    }

    public static void main(String[] args) {
        MinimumPathSum test = new MinimumPathSum();
        int[][] list = {{1,3,1},{1,5,1},{4,2,1}};
        test.minPathSum(list);
    }
}
