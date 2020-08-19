package dataStructure;

public class UndiGraph extends Graph {
    public UndiGraph(int v) {
        super(v);
    }

    @Override
    public void addEdge(int v, int w) {
        if(v>=V||w>=V)return;
        list[v].add(w);
        list[w].add(v);
    }
}
