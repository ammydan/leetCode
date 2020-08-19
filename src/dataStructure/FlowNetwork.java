package dataStructure;

import java.util.LinkedList;

/**
 * 这个数据结构的关键点：
 * 1、怎么寻找增量路径（随机、DFS、最短路径、最快路径）
 * */
public class FlowNetwork {
    private final int V;
    private LinkedList<FlowEdge>[] adj;
    public FlowNetwork(int V){
        this.V = V;
        adj = new LinkedList[V];
        for(int i=0;i<V;i++){
            adj[i] = new LinkedList<>();
        }
    }
    public void addEdge(FlowEdge e){
        int v = e.from();
        int w = e.to();
        adj[v].add(e);
        adj[w].add(e);
    }
    public Iterable<FlowEdge> adj(int v){
        return adj[v];
    }

    public int getV() {
        return V;
    }
}
