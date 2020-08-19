package dataStructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 单点到所有其他点的最短路径
 * 1、迪杰斯特拉算法（无负数）
 * 技巧一：需要进行松弛
 * distTo[v]是记录的s到v的最短距离
 * distTo[w]是记录s到v的最短距离
 * edgeTo[w]是s到w的距离
 * 松弛的时机，就是刚拿到最新最短路径时，需要再次更新图中的距离
 * 时间复杂度：O((V+E)*logV)
 * 2、DAG更简单的算法。
 * ①先求Topological order
 * ②再按照顺序遍历
 * 时间复杂度：O(V+E)
 * 3、SPFA/Bellman-Ford
 * relax所有的边
 * 时间复杂度：O(EV)
 *for (var i = 0; i < n - 1; i++) {
 *     for (var j = 0; j < m; j++) {//对m条边进行循环
 *       var edge = edges[j];
 *       // 松弛操作
 *       if (distance[edge.to] > distance[edge.from] + edge.weight ){
 *         distance[edge.to] = distance[edge.from] + edge.weight;
 *       }
 *     }
 * }
 * for (var i=0; i<m;i++)
 *         var edge = edges[i]
 *         do if d[edge.to] > d[edge.from] + edge.weight
 *              then return FALSE
 * 4、Floyd算法（类似于DP，需要用OPT[i][j]矩阵来记录点到点的距离）
 * 解决任意两点间的最短距离。多源最短路径。
 * 中间K的顺序进行，表明可以进过0-k点的最短路径i-j（不一定要经过全部的中间点0-k）
 * for(int k = 0;k<len;k++){
 *     for(int i = 0 ;i<len;i++){
 *          for(int j = 0;j<len;j++){
 *
 *          }
 *     }
 * }
 * 时间复杂度：O(V^3)
 *
 * */
public class SP {
    private int source;
    private double[] distTo;
    private DirectedEdge [] edgeTo;
    private EdgeWeightDigraph graph;
    public SP(int source, EdgeWeightDigraph graph){
        this.source = source;
        this.graph = graph;
        Arrays.fill(distTo,Integer.MAX_VALUE);
        distTo[0] = 0;
        int nums = graph.getV();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums;i++){
            set.add(i);
        }
        while(!set.isEmpty()){
            Double min = Double.MAX_VALUE;
            int min_index = -1;
            for(int i: set){
                if(distTo[i]<min){
                    min = distTo[i];
                    min_index = i;
                }
            }
            set.remove(min_index);
            for(DirectedEdge i: graph.adj(min_index)){
                relax(i);
            }
        }

    }
    public void DAG(){

    }
    private void relax(DirectedEdge e){
        int v = e.from(),w = e.to();
        if(distTo[w]>distTo[v]+e.weight()){
            distTo[w] = distTo[v]+e.weight();
            edgeTo[w] = e;
        }
    }
    public double[] cost(){
        return distTo;
    }
    public DirectedEdge[] paths(){
        return edgeTo;
    }

    public static void main(String[] args) {
    }

}
