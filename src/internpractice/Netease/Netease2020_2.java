package internpractice.Netease;

import java.util.Scanner;

public class Netease2020_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            int turns = in.nextInt();
            for(int i=0;i<turns;i++){
                int rows = in.nextInt();
                int cols = in.nextInt();
                int nums = in.nextInt();
                boolean[][] full = new boolean[rows+1][cols+1];
                for(int j = 0;j<nums;j++){
                    int row = in.nextInt();
                    int col = in.nextInt();
                    full[row][col] = true;
                }
                int width = in.nextInt();
                int length = in.nextInt();
                boolean flag = false;
                for(int j = width;j<=rows;j++){

                    for(int k = length;k<=cols;k++){
                        if(valid(full,j,k,width,length)){
                            System.out.println("YES");
                            flag = true;
                            break;
                        }
                    }
                    if(flag)break;
                }
                if(!flag) System.out.println("NO");
        }
    }
    public static boolean valid(boolean[][] full, int row, int col, int width,int length){
        for(int i = row-width+1;i<=row;i++){
            for(int j = col-length+1;j<=col;j++){
                if(full[i][j])return false;
            }
        }
        return true;
    }
}
