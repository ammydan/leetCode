package everyday;

/**
 *easy 70
 * 比较简单的动态规划。
 * 1、自己想法：
 * 动态规划
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 2、参考思路
 *①动态规划提升版本（因为我们只使用了前两个阶梯来计算出后面的答案，所以根本不需要那么多的空间）
 *②快速矩阵（其实这里就可以想到，本质上和斐波那契数列类似）
 * 快速矩阵介绍：
 * 如果我们想要计算A^N，那么我们一般人就会老老实实计算N次得到答案，但是如果我们分开呢？
 * 比如我们想计算A^156——>A^(2^7+2^4+2^3+2^2)我们总共只需要计算4*8次即可得到答案。
 * 接着我们只需要实现矩阵相乘，然后按照快速次方的代码来进行计算，则可以得到快速矩阵
 * 注意：这里我是第一次遇到，连O(n)都可能超时的情况。
 * 如何将递推数列快速转化为矩阵：
 * f(n) = Σai*f(n-i) (i∈(1……m))此时将ai作为矩阵第一排，然后接下来几排按照只有一个为1，并且1出现的次序一次推后。
 * 然后我们可以开始我们的大业了，哇咔咔。
 * 时间复杂度：O(logn)
 * 空间复杂度：O(1)
 * */

//这里是一段参考的快速次方的代码
//int QuickPow(int x,int N)
//{
//    int res = x;
//    int ans = 1;
//    while(N)
//    {
//    if(N&1)
//    {
//    ans = ans * res;
//    }
//    res = res*res;
//    N = N>>1;
//    }
//    return ans;
//}
public class ClimbingStairs {
    public int climbStair(int n){
//        1、自己进行的动态规划
//        int[] ans = new int[n+1];
//        ans[0] = 1;
//        ans[1] = 1;
//        for(int i=2;i<=n;i++){
//            ans[i] = ans[i-1]+ans[i-2];
//        }
//        return ans[n];
//        2、参考：提升的动态规划
//        int one=1, two=1,ans=0;
//        for(int i=2;i<=n;i++){
//            ans = one +two;
//            one = two;
//            two = ans;
//        }
//        return ans;
//        3、快速矩阵
        int [][] A = new int[2][2];
        int [][] B = new int[2][1];
        A[0][1] = 1;
        A[0][0] = 1;
        A[1][0] = 1;
        B[0][0] = 1;
        B[1][0] = 1;
        A = quickPowerMatrix(A,n-1);
        B = multipleMatrix(A,B);
        return B[0][0];

    }
    private int[][] multipleMatrix(int[][] a, int[][] b){
        int lenRow = a.length;
        int lenCol = a[0].length;
        int lenColB = b[0].length;
        int[][] ans = new int[lenRow][lenColB];
        for(int i=0;i<lenRow;i++){
            for(int j=0;j<lenColB;j++){
                for(int k=0;k<lenCol;k++){
                    ans[i][j] = a[i][k]*b[k][j];
                }
            }
        }
        return ans;
    }
    private int[][] quickPowerMatrix(int[][] matrix, int N){
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] temp = new int[row][col];
        for(int i=0;i<row;i++){
            temp[i][i] = 1;
        }
        while(N>0){
            if((N&1)>1){
                temp = multipleMatrix(matrix,temp);
            }
            matrix = multipleMatrix(matrix,matrix);
            N>>=1;
        }
        return temp;
    }
}
