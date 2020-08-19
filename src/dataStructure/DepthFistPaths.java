package dataStructure;

import java.util.LinkedList;
import java.util.List;

public class DepthFistPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFistPaths(Graph G, int s){
        int len = G.getNumNodes();
        marked = new boolean[len];
        edgeTo = new int[len];
        this.s = s;
    }
    private void dfs(Graph G,int v){
        LinkedList<Integer> stack = new LinkedList<>();
        edgeTo[v] = -1;
        stack.push(v);
        marked[v] = true;
        while(!stack.isEmpty()){
            int current = stack.pop();
            List<Integer> list = G.adj(current);
            for(int i: list){
                if(!marked[i]){
                    marked[i] = true;
                    edgeTo[i] = current;
                    stack.push(i);
                }
            }
        }
    }
    public int[] path(){return edgeTo;}
}
