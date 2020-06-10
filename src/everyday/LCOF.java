package everyday;

/**
 * middle 面试题：顺时针打印矩阵
 * 自己思路：
 * 这题第一眼就感觉用模拟的方法进行打印。分为四个方向：左下右上，用width和height记录打印一行和一列还剩下的元素个数。
 * 这里出现了一个bug就是，当遇到最后一行或者最后一列的时候，会直接减去所有的width和height，所以要增加一个判断，看width和height任意一个为零
 * 那么我们就要跳出循环。而且后面参数的减少也要考虑到只有进行过循环的才进行处理。
 * 时间复杂度O(NM)
 * 这里其实要比nm高不少，因为实现的底层一列的循环往往比一行的循环要慢很多。
 *
 * 参考思路：
 * 1、模拟
 * ①创建一个boolean矩阵，伴随着原矩阵进行循环判断该元素是否已经使用。
 * ②我们可以创建一个方向的数组，按照4个方向循环的顺序进行不断循环（时机就是超过边界，或者元素已经被访问）
 * 时间复杂度O(NM)
 * 同样时间要慢，而且空间复杂度上去了，但是整体代码要比我的简洁许多。
 *
 * 2、也是同样的模拟
 * 四个边界
 *
* */
public class LCOF {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0)return new int[0];
        int height = matrix.length;
        int width = matrix[0].length;
        int row=0, col=0;
        int []ans = new int[height*width];
        int index = 0;
        boolean flag=false;
        while(height>0&&width>0){
            for(int i=col;col<i+width;col++){

                ans[index++] = matrix[row][col];
                flag = true;
                System.out.print(index);
                System.out.println("ran 1");
            }
            if(flag){
                height--;
                row++;
                col--;
                if(height==0)break;
                flag=false;
            }

            for(int i=row;row<i+height;row++){

                ans[index++] = matrix[row][col];
                flag=true;
                System.out.print(index);
                System.out.println("ran 2");
            }
            if(flag){
                width--;
                col--;
                row--;
                if(width==0)break;
                flag = false;
            }

            for(int i=col;col>i-width;col--){

                ans[index++] = matrix[row][col];
                flag = true;
                System.out.print(index);
                System.out.println("ran 3");
            }
            if(flag){
                height--;
                row--;
                col++;
                if(height==0)break;
                flag=false;
            }

            for(int i=row;row>i-height;row--){

                ans[index++] = matrix[row][col];
                flag = true;
                System.out.print(index);
                System.out.println("ran 4");
            }
            if(flag){
                width--;
                col++;
                row++;
                if(width==0)break;
                flag=false;
            }

        }
        return ans;
    }
}
