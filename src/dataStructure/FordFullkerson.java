package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class FordFullkerson {
    private boolean[] marked;
    private FlowEdge[] edgeTo;
    private double value;
    public FordFullkerson(FlowNetwork G, int s, int t){
        value = 0.0;
        while(hasAugmentingPath(G,s,t)){
            double bottle = Double.POSITIVE_INFINITY;
            for(int v = t;v!=s;v=edgeTo[v].other(v)){
                bottle = Math.min(bottle,edgeTo[v].residualCapacityTo(v));
            }
            for(int v=t;v!=s;v=edgeTo[v].other(v)){
                edgeTo[v].addResidualFlowTo(v,bottle);
            }
            value+=bottle;
        }
    }
    private boolean hasAugmentingPath(FlowNetwork G, int s,int t){
        edgeTo = new FlowEdge[G.getV()];
        marked = new boolean[G.getV()];

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(s);
        marked[s] = true;
        while(!queue.isEmpty()){
            int v = queue.poll();
            for(FlowEdge e: G.adj(v)){
                int w = e.other(v);
                if(!marked[w]&&(e.residualCapacityTo(w)>0)){
                    edgeTo[w] = e;
                    marked[w] = true;
                    queue.offer(w);
                }
            }
        }
        return marked[t];
    }
    public double getValue(){
        return value;
    }
    public boolean inCut(int v){
        return marked[v];
    }
}
