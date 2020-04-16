package middle;

public class MinimumPathSum_DP {
    public int minPathSum(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] sum = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int value1=Integer.MAX_VALUE,value2=Integer.MAX_VALUE;
                if(i==0&&j==0){
                    sum[i][j] = grid[i][j];
                    continue;
                }
                if(i-1>=0)value1 = sum[i-1][j];
                if(j-1>=0)value2 = sum[i][j-1];
                sum[i][j] = Math.min(value1,value2)+grid[i][j];
            }
        }
        return sum[rows-1][cols-1];
    }

    public static void main(String[] args) {
        MinimumPathSum_DP minimumPathSum = new MinimumPathSum_DP();
//        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] grid = {{1,2,5},{3,2,1}};
        int x = minimumPathSum.minPathSum(grid);
        System.out.println(x);
    }
}
