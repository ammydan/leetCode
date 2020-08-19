package middle;

import dataStructure.ArrayTree;

import java.util.Arrays;

public class WordSearch {
    boolean[][] marked;
    int rows, cols, len;
    int[][] direct={{0,1,0,-1},{-1,0,1,0}};
    public boolean exist(char[][] board, String word){
        this.rows = board.length;
        if(rows<=0)return false;
        this.cols = board[0].length;
        this.len = word.length();
        this.marked = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(dfs(board,word,i,j,0))return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][]board, String word,int row,int col, int index){
        if(index==len-1){
            if(board[row][col]==word.charAt(index))return true;
            return false;
        }
        if(board[row][col]==word.charAt(index)){
            marked[row][col] = true;
            for(int i=0;i<4;i++){
                int tempRow = row+direct[0][i];
                int tempCol = col+direct[1][i];
                if(inArea(tempRow,tempCol)){
                    if(dfs(board,word,tempRow,tempCol,index+1))return true;
                }
            }
            marked[row][col] = false;
        }
        return false;

    }
    private boolean inArea(int row,int col){
        return row>=0&&row<rows&&col>=0&&col<cols&&!marked[row][col];
    }

    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };

        String word = "SEE";

        WordSearch test = new WordSearch();
        boolean exist = test.exist(board, word);
        System.out.println(exist);

    }
}
