package everyday;
/**
 *329 hard
 * 其实这个并不算难
 * 1、自己的想法：递归+记忆化
 * 因为要求是递增，那么我们想想从某一个单元开始它的最长路径是多少？（如果四周存在有比这个单元大的单元）是不是1+周围单元最长路径。
 * 是不是瞬间有了递归的想法，那么我们还可以做一次记忆存储，记录单元的最长路径。（我们无需考虑重复的问题，因为是严格递增，递归所选择的路径绝对不会重复）。
 * */
public class LongestIncreasingPathinaMatrix {
    private int[][] matrix;
    private int[][] direct = {{0,1,0,-1},{-1,0,1,0}};
    private int[][] opt;
    public int longestIncreasingPath(int[][]matrix){
        this.matrix = matrix;
        int rows = matrix.length;
        if(rows==0)return 0;
        int cols = matrix[0].length;
        opt = new int[rows][cols];
        int ans = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int temp = helper(i,j);
                ans = ans>=temp?ans:temp;
            }
        }
        return ans;
    }
    private int helper(int row, int col){
        if(opt[row][col]!=0)return opt[row][col];
        int value = matrix[row][col];
        int num = 1;
        for(int i=0;i<4;i++){
            int newRow = row+direct[0][i];
            int newCol = col+direct[1][i];
            if(valid(newRow,newCol)&&matrix[newRow][newCol]>value){
                int temp = helper(newRow,newCol);
                num = 1+temp>num?1+temp:num;
            }
        }
        opt[row][col] = num;
        return num;
    }
    private boolean valid(int row, int col){
        return row<matrix.length&&row>=0&&col<matrix[0].length&&col>=0;
    }
}
