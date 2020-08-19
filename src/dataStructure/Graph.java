package dataStructure;

import java.util.LinkedList;

/**
 * 1、Graph terminology:
 * ①Path: Sequence of vertices connected by edges
 * ②Cycle: Path whose first and last vertices are the same.
 * ③Connect: Two vertices are connected if there is a path between them.
 * 2、Implementation
 * ①Adjacency-matrix
 * ②Adjacency-list
 * */
public abstract class Graph {
    protected final int V;
    protected LinkedList<Integer> [] list;
    public Graph(int v){
        this.V = v;
        list = new LinkedList[v];
        for(int i=0;i<v;i++){
            list[i] = new LinkedList<>();
        }
    }
    public void addEdge(int v, int w){
    }
    public LinkedList<Integer> adj(int v){
        if(v>=V)return null;
        return list[v];
    }
    public int getNumNodes(){
        return V;
    }
}
