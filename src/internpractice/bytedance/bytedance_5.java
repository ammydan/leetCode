package internpractice.bytedance;

import java.util.Scanner;

public class bytedance_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] map = new int[n][n];
        boolean[] marked = new boolean[n];
        for(int i =0;i<n;i++){
            for(int j = 0;j<n;j++){
                map[i][j] = in.nextInt();
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){

            if(i==n-1){
                ans+=map[i][0];
                continue;
            }
            int min = Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                if(!marked[j]&&i!=j)min = min<map[i][j]?min:map[i][j];
            }
            ans+=min;

        }
        System.out.println(ans%99997867);

    }
}
