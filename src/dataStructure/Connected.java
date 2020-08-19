package dataStructure;

import java.util.List;

public class Connected {
    private int [] id;
    private boolean[]marked;

    public Connected(Graph graph){
        int len = graph.getNumNodes();
        id = new int[len];
        marked = new boolean[len];
        int myID = 0;
        if(graph instanceof Digraph){
            Digraph digraph = (Digraph) graph;
            Digraph digraphReverse = digraph.reverse();
            Topological topol = new Topological(digraphReverse);
            List<Integer> list = (List<Integer>) topol.reversePostOrder();
            for(int i: list){
                if(!marked[i]){
                    dfs(graph,i,myID);
                    myID++;
                }
            }
        }else{
            for(int i=0;i<len;i++){
                if(!marked[i]){
                    dfs(graph,i,myID);
                    myID++;
                }
            }
        }
    }
    public boolean connected(int v, int w){
        return id[v]==id[w];
    }
    private void dfs(Graph g, int current, int currentID){
        id[current] = currentID;
        marked[current] = true;
        for(int i: g.adj(current)){
            if(!marked[i]){
                dfs(g,i,currentID);
            }
        }
    }

    public static void main(String[] args) {
        Digraph g = new Digraph(13);
        g.addEdge(0,1);
        g.addEdge(0,5);
        g.addEdge(6,0);
        g.addEdge(2,3);
        g.addEdge(2,0);
        g.addEdge(4,3);
        g.addEdge(4,2);
        g.addEdge(3,2);
        g.addEdge(5,4);
        g.addEdge(3,5);
        g.addEdge(6,0);
        g.addEdge(6,4);
        g.addEdge(6,8);
        g.addEdge(8,6);
        g.addEdge(7,6);
        g.addEdge(7,9);
        g.addEdge(6,9);
        g.addEdge(9,10);
        g.addEdge(9,11);
        g.addEdge(11,12);
        g.addEdge(11,4);
        g.addEdge(10,12);
        g.addEdge(12,9);
        Connected test = new Connected(g);
        System.out.println(test.connected(0,2));
        System.out.println(test.connected(3,4));
    }
}
