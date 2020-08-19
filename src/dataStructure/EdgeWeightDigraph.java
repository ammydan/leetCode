package dataStructure;

import java.util.LinkedList;

public class EdgeWeightDigraph {
    private final int V;
    private final LinkedList<DirectedEdge>[] adj;
    public EdgeWeightDigraph(int V){
        this.V = V;
        adj = new LinkedList[V];
        for(int i = 0;i<V;i++){
            adj[i] = new LinkedList<>();
        }
    }
    public void addEdge(DirectedEdge e){
        int v = e.from();
        adj[v].add(e);
    }
    public Iterable<DirectedEdge>adj(int v){
        return adj[v];
    }
    public int getV(){
        return V;
    }
}
