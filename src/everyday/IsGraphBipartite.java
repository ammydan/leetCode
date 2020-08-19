package everyday;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
/**
 *785 middle
 * 这道题其实不难，但是第一次做想出方法，并且完全自己写出来还是需要一点时间的。
 * 1、自己的思路
 * 一开始看到鉴别是否在一个集合里的要求就想到的是set数据结构，但是怎么进行遍历比较呢？
 * 一开始想着是按顺序遍历过去，但是完成后发现，遍历到后面可能出现已经分到set中的点之间可能还有edge，但是前面
 * 已经分完（其实颠倒一下就可以，因为当时点少根本没有冲突的情况下随便分的）。
 * 后面又想着如果已经分了的话，我们需要直接分这些分好了的，因为和他们相连的一定是要分配到另一个集合。
 * 时间复杂度：O(N+M)
 * 空间复杂度：O(N)
 * 2、参考思路
 * ①广度优先搜索
 * 给每个点涂上颜色，下一层的点一定要和父节点的点颜色不一样。
 * 时间复杂度：O(N+M)
 * 空间复杂度：O(N+M)
 *
 * */
public class IsGraphBipartite {
    private final int RED = 1;
    private final int BLACK = 2;
    int[] color ;
    public boolean isBipartite(int[][] graph){
//        int rows = graph.length;
//        int cols = graph.length;
//        if(rows<2)return true;
//        HashSet<Integer> set1 = new HashSet<>();
//        HashSet<Integer> set2 = new HashSet<>();
//        LinkedList<Integer> stack1 = new LinkedList<>();
//        LinkedList<Integer> stack2 = new LinkedList<>();
//        boolean flag[] = new boolean[rows];
//        int i = 0;
//        while(i<rows||!stack1.isEmpty()||!stack2.isEmpty()){
//            while(!stack1.isEmpty()){
//                int x = stack1.pop();
//                if(set2.contains(x))return false;
//                set1.add(x);
//                if(!flag[x]){
//                    for(int temp: graph[x]){
//                        stack2.push(temp);
//                    }
//                }
//                flag[x] = true;
//            }
//            while(!stack2.isEmpty()){
//                int x = stack2.pop();
//                if(set1.contains(x))return false;
//                set2.add(x);
//                if(!flag[x]){
//                    for(int temp: graph[x]){
//                        stack1.add(temp);
//                    }
//                }
//                flag[x] = true;
//            }
//            while(i<rows&&flag[i])i++;
//            if(!stack1.isEmpty()||!stack2.isEmpty())continue;
//            else if(i<rows){
//                set1.add(i);
//                for(int temp: graph[i]){
//                    stack2.add(temp);
//                }
//                flag[i] = true;
//                i++;
//            }
//        }
//        return true;
        int rows = graph.length;
        if(rows<=1)return true;
        color = new int[rows];
        Arrays.fill(color,-1);
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0;i<rows;i++){
            if(color[i]==-1){
                color[i] = 1;
                queue.add(i);
                if(!bfs(queue,graph))return false;
            }
        }
        return true;
    }
    private boolean bfs(LinkedList<Integer> queue,int[][] graph){
        while(!queue.isEmpty()){
            int node = queue.pop();
            int c = color[node];
            for(int i: graph[node]){
                if(color[i]==c)return false;
                if(color[i]==-1){
                    color[i] = 3-c;
                    queue.add(i);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsGraphBipartite test = new IsGraphBipartite();
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        test.isBipartite(graph);
    }
}
