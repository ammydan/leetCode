package everyday;

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if(rows<=1||cols<=1)return 1;
        int[][] opt = new int[rows+1][cols+1];
        opt[0][1] = 0;
        opt[1][0] = 1;
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=cols;j++){
                if(obstacleGrid[i-1][j-1]==1)opt[i][j]=0;
                else opt[i][j] = opt[i-1][j]+opt[i][j-1];
            }
        }
        return opt[rows][cols];
    }
}
