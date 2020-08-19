package dataStructure;

import java.util.*;

public class MST {
    private boolean[] marked;
    private LinkedList<Edge> mst = new LinkedList<>();
    private PriorityQueue<Edge> pq;
    public MST(EdgeWeightedGraph graph){
//        Kruskal's algorithm
//        LinkedList<Edge> orderList = (LinkedList<Edge>) graph.edges();
//        Collections.sort(orderList);
//        int len = orderList.size();
//        marked = new boolean[len];
//        while(!orderList.isEmpty()){
//            Edge edge = orderList.pop();
//            int v = edge.either();
//            if(marked[v]&&marked[edge.other(v)])continue;
//            marked[v]= true;
//            marked[edge.other(v)] = true;
//            mst.add(edge);
//        }
//        Prim's algorithm
        pq = new PriorityQueue();
        marked = new boolean[graph.getV()];
        visit(graph,0);
        while(!pq.isEmpty()&&mst.size()<graph.getV()-1){
            Edge edge = pq.remove();
            int node = edge.either();
            if(marked[node]&&marked[edge.other(node)])continue;
            mst.add(edge);
            node = marked[node]?edge.other(node):node;
            visit(graph,node);
        }
    }
    private void visit(EdgeWeightedGraph graph, int node){
        marked[node] = true;
        for(Edge edge: graph.adj(node)){
            if(!marked[edge.other(node)])pq.add(edge);
        }
    }
    public Iterable<Edge> edges(){
        return mst;
    }

    public static void main(String[] args) {
        EdgeWeightedGraph graph = new EdgeWeightedGraph(8);
        graph.addEdge(new Edge(0,7,0.16));
        graph.addEdge(new Edge(0,2,0.26));
        graph.addEdge(new Edge(2,3,0.17));
        graph.addEdge(new Edge(5,7,0.28));
        graph.addEdge(new Edge(4,5,0.35));
        graph.addEdge(new Edge(6,2,0.40));
        graph.addEdge(new Edge(1,7,0.19));
        graph.addEdge(new Edge(1,5,0.32));
        graph.addEdge(new Edge(1,2,0.36));
        graph.addEdge(new Edge(3,6,0.52));
        graph.addEdge(new Edge(6,0,0.58));
        graph.addEdge(new Edge(6,4,0.93));
        graph.addEdge(new Edge(1,3,0.29));
        graph.addEdge(new Edge(2,7,0.34));
        graph.addEdge(new Edge(4,7,0.37));
        graph.addEdge(new Edge(0,4,0.38));
        MST test = new MST(graph);
        List<Edge> list = (List<Edge>) test.edges();
        for(Edge edge:list){
            int v = edge.either();
            System.out.println("("+v+","+edge.other(v)+")");
        }
    }
}
