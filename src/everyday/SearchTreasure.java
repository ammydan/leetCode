package everyday;

import java.util.Arrays;
import java.util.LinkedList;

public class SearchTreasure {
//    private String [] maze;
//    private int[][] direct = {{0,1,0,-1},{-1,0,1,0}};
//    private int rows,cols;
//    public int minimalSteps(String[] maze){
//
//    }
//
//    private int bfs(int[] source, int[] target){
//        LinkedList<int[]> queue = new LinkedList<>();
//        int []init = new int[3];
//        boolean[][] marked = new boolean[maze.length][maze[0].length()];
//        init[0] = source[0];
//        init[1] = source[1];
//        init[2] = 0;
//        queue.add(init);
//        marked[init[0]][init[1]] = true;
//        while(!queue.isEmpty()){
//            int[] current = queue.pop();
//            if(arrayEquals(current,target))return current[2];
//            for(int i=0;i<4;i++){
//                int row = current[0]+direct[0][i];
//                int col = current[1]+direct[1][i];
//                if(valid(row,col)&&!marked[row][col]){
//                    int[] temp = new int[3];
//                    temp[0] = row;
//                    temp[1] = col;
//                    temp[2] = 1+current[2];
//                    queue.push(temp);
//                }
//            }
//        }
//        return -1;
//    }
//    private boolean arrayEquals(int[]a,int[]b){
//        return a[0]==b[0]&&a[1]==b[1];
//    }
//    private boolean valid(int row, int col){
//        return row>=0&&row<rows&&col>=0&&col<cols;
//    }
}
