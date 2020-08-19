package everyday;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * Hard 174
 * 1、自己的想法
 * 这个第一个在脑中蹦出来的就是图的最短路径算法，但是超时了。
 * 然后想着这个肯定是DP，但是DP正着来我又发现自己搞出了错误,按照正面的顺序我们需要根据两个条件进行判断。
 * 但是两个条件会有冲突的地方，这完全违背了DP的初衷（DP只能让一个值作判断否则子问题根本没有解决）。
 * 时间复杂度：O(M*NlogM*N)
 * 2、参考思路
 * ①DP：逆向DP
 * 我们反过来呢？我们要计算opt[i][j]（进入(i,j)之前的生命值是多少），但是还是同样的会遇到类似的问题。但是这里有一个技巧
 * 我们知道进来之前生命值不可以为负或者0，哪怕你这个地方(i,j)加血，你也不可能死后还可以挪到加血的地方，所以凡是遇到opt[i][j]
 * 要为负数的时候就直接返回0(最终答案会+1)，因为你要保证你前面过来的时候不能死（你逆序DP已经保证后面的路是不会死的）。
 * 时间复杂度：O(M*N)
 * 空间复杂度：O(M*N)
 * ②优化空间
 * 根据状态方程判断每次需要的几个子问题的值，然后进行优化。
 * */
public class DungeonGame{
     private class Node implements Comparable<Node>{
        int x,y,value,min;
        public Node(int x, int y, int value,int min){
            this.x = x;
            this.y = y;
            this.value = value;
            this.min = min;
        }

         @Override
         public int compareTo(Node o) {
             if(min>o.min)return -1;
             else if(min<o.min)return 1;
             return 0;
         }
     }
    public int calculateMinimumHP(int[][] dungeon){
//        int rows = dungeon.length;
//        int cols = dungeon[0].length;
//        if(rows<1||cols<1)return 1;
//        PriorityQueue<Node> pq = new PriorityQueue<>();
//        pq.add(new Node(0,0,dungeon[0][0],dungeon[0][0]));
//        int ans = Integer.MAX_VALUE;
//        while(!pq.isEmpty()){
//            Node temp = pq.remove();
//            if(temp.x==rows-1&&temp.y==cols-1){
//                if(temp.min<0)ans = -temp.min+1;
//                else ans = 1;
//                break;
//            }
//            if(temp.x+1<rows){
//                int value = dungeon[temp.x+1][temp.y]+temp.value;
//                int min = value<temp.min?value:temp.min;
//                pq.add(new Node(temp.x+1,temp.y,value,min));
//            }
//            if(temp.y+1<cols){
//                int value = dungeon[temp.x][temp.y+1]+temp.value;
//                int min = value<temp.min?value:temp.min;
//                pq.add(new Node(temp.x,temp.y+1,value,min));
//            }
//        }
//        return ans;
//        2、参考思路①：逆序DP
//        int rows = dungeon.length;
//        int cols = dungeon[0].length;
//        if (rows < 1||cols<1)return 1;
//        int[][] opt = new int[rows][cols];
//
//        for(int i=rows-1;i>=0;i--){
//            for(int j=cols-1;j>=0;j--){
//                if(i==rows-1&&j==cols-1){
//                    if(dungeon[i][j]>0)opt[i][j] = 0;
//                    else opt[i][j]= -dungeon[i][j];
//                    continue;
//                }
//                int right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;
//                if(i+1<rows)down = opt[i+1][j];
//                if(j+1<cols)right = opt[i][j+1];
//                opt[i][j] = Math.min(right,down)-dungeon[i][j];
//                opt[i][j] = Math.max(opt[i][j],0);
//            }
//        }
//        return opt[0][0]+1;
//        3、优化空间
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        if(rows<1||cols<1)return 1;
        int [] opt = new int[cols+1];
        Arrays.fill(opt,Integer.MAX_VALUE);
        opt[cols] = 0;
        for(int i=rows-1;i>=0;i--){
            for(int j=cols-1;j>=0;j--){
                opt[j] = Math.min(opt[j],opt[j+1])-dungeon[i][j];
                opt[j] = Math.max(opt[j],0);
                opt[cols] = Integer.MAX_VALUE;
            }
        }
        return opt[0]+1;
    }

    public static void main(String[] args) {
        DungeonGame test = new DungeonGame();
        int[][] map = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
//        int[][] map = {{1,-3,3},{0,-2,0},{-3,-3,-3}};
        test.calculateMinimumHP(map);
    }
}
