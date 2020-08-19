package dataStructure;

import java.util.LinkedList;

public class BreadthFirstPaths {
    private boolean []marked;
    private int [] edgeTo;
    private int s;
    public BreadthFirstPaths(Graph g, int s){
        int len = g.getNumNodes();
        marked = new boolean[len];
        edgeTo = new int[len];
        this.s = s;
        BFS(g,s);
    }
    private void BFS(Graph g, int s){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(s);
        marked[s] = true;
        edgeTo[s] = -1;
        while(!queue.isEmpty()){
            int current = queue.pop();
            for(int node: g.adj(current)){
                if(marked[node])continue;
                marked[node] = true;
                edgeTo[node] = current;
                queue.add(node);
            }
        }
    }
    public int[] path(){return edgeTo;}

}
