package dataStructure;

import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedGraph {
    private final int v;
    private LinkedList<Edge>[] adj;
    public EdgeWeightedGraph(int v){
        this.v = v;
        this.adj = new LinkedList[v];
        for(int i=0;i<v;i++){
            this.adj[i] = new LinkedList<>();
        }
    }
    public void addEdge(Edge e){
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }
    public Iterable<Edge> adj(int v){
        return adj[v];
    }
    public Iterable<Edge> edges(){
        List<Edge> list = new LinkedList<>();
        for(int i=0;i<this.v;i++){
            for(Edge edge:this.adj[i]){
                list.add(edge);
            }
        }
        return list;
    }
    public int getV(){
        return v;
    }
}
