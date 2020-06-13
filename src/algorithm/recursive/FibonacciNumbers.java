package algorithm.recursive;

import java.io.FileOutputStream;

public class FibonacciNumbers {
    public int fib(int N){
        if(N==0)return 0;
        if(N<=2)return 1;
        int[][] A = {{1,1},{1,0}};
        A = pow(A,N-2);
        int[][] f = {{1},{1}};
        return multipleMatrix(A,f)[0][0];
    }
    private int[][] multipleMatrix(int[][]A, int[][]B){
        int lenRowA = A.length;
        int lenColB = B[0].length;
        int len = A[0].length;
        int[][] ans = new int[lenRowA][lenColB];
        for(int i=0;i<lenRowA;i++){
            for(int j=0;j<lenColB;j++){
                for(int k =0;k<len;k++){
                    ans[i][j]+= A[i][k]*B[k][j];
                }
            }
        }
        return ans;
    }
    private int[][] pow(int[][]A,int N){
        int[][] ans = {{1,0},{0,1}};
        while(N>0){
            if((N&1)>0){
                ans = multipleMatrix(A,ans);
            }
            A = multipleMatrix(A,A);
            N = N>>1;
        }
        return ans;
    }

    public static void main(String[] args) {
        FibonacciNumbers test = new FibonacciNumbers();
        int ans = test.fib(3);
        System.out.println(ans);
    }
}
