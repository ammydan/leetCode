package contest.contest20200705;

import java.util.LinkedList;
/**
 * middle 1504
 * */
public class NumSubmat {
    public int numSubmat(int[][]mat){
//        1、压缩矩阵方法
//        int rows = mat.length;
//        int cols = mat[0].length;
//        int ans = 0;
//        for(int i=0;i<rows;i++){
//            for(int j = i;j<rows;j++){
//                int temp = 0;
//                for(int k=0;k<cols;k++){
//                    temp = mat[j][k]==1?temp+1:0;
//                    ans+=temp;
//                }
//            }
//            for(int j=rows-1;j>i;j--){
//                for(int k=0;k<cols;k++){
//                    mat[j][k] = mat[j-1][k]&mat[j][k];
//                }
//            }
//        }
//        return ans;
//        2、单调栈方法
//        int rows = mat.length;
//        int cols = mat[0].length;
//        int ans = 0;
//        int [][] tempSum = new int[rows][cols];
//        for(int i=0;i<rows;i++){
//            int temp = 0;
//            for(int j=0;j<cols;j++){
//                temp = mat[i][j]==1?temp+1:0;
//                tempSum[i][j] = temp;
//            }
//        }
//        for(int i=0;i<cols;i++){
//            int sum = 0;
//            LinkedList <int[]> stack = new LinkedList<>();
//            for(int j=0;j<rows;j++){
//                int current = tempSum[j][i];
//                int height = 1;
//                while(!stack.isEmpty()&&stack.getFirst()[0]>current){
//                    sum -=stack.getFirst()[1]*(stack.getFirst()[0]-current);
//                    height+=stack.getFirst()[1];
//                    stack.pop();
//                }
//                int [] pairs = new int[2];
//                sum+=current;
//                ans+=sum;
//                pairs[0] = current;
//                pairs[1] = height;
//                stack.push(pairs);
//            }
//        }
//        return ans;
        int rows = mat.length;
        int cols = mat[0].length;
        int[][]rowSum = new int[rows][cols];
        for(int i=0;i<rows;i++){
            int temp = 0;
            for(int j=0;j<cols;j++){
                if(mat[i][j]==1){
                    rowSum[i][j] = temp+1;
                    temp++;
                }else temp = 0;
            }
        }
        int ans = 0;
        for(int j = 0;j<cols;j++){
            int sum = 0;
            LinkedList<int[]> stack = new LinkedList<>();
            for(int i=0;i<rows;i++){
                int height = 1;
                while(!stack.isEmpty()&&stack.peekFirst()[1]>rowSum[i][j]){
                    int[] temp = stack.pop();
                    sum-=temp[0]*(temp[1]-rowSum[i][j]);
                    height+=temp[0];
                }
                sum+=rowSum[i][j];
                ans+=sum;
                int[] temp = new int[2];
                temp[0] = height;
                temp[1] = rowSum[i][j];
                stack.push(temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumSubmat test = new NumSubmat();
//        int[][] mat = {{1,0,1},{1,1,0},{1,1,0}};
//        int[][] mat = {{1,1,1,1,1,1}};
        int[][] mat = {{0,1,1,0},{0,1,1,1},{1,1,1,0}};
//        int[][] mat = {{0,0,0},{0,0,0},{0,1,1},{1,1,0},{0,1,1}};
        test.numSubmat(mat);
    }
}
