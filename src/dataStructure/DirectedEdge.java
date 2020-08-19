package dataStructure;

public class DirectedEdge {
    private final int v, w;
    private final double weight;
    public DirectedEdge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public int from(){
        return v;
    }
    public int to (){
        return w;
    }
    double weight(){
        return weight;
    }
    public String toString(){
        return "("+v+","+w+","+weight+")";
    }
}
