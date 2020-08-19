package dataStructure;

import java.util.LinkedList;

public class Digraph extends Graph {
    public Digraph(int v) {
        super(v);
    }

    @Override
    public void addEdge(int v, int w) {
        if(v>=V||w>=V)return;
        list[v].add(w);
    }


    public static void main(String[] args) {
        LinkedList<String>test = new LinkedList<>();
        test.push("hello");
        test.push("xx");
        for(String str: test){
            System.out.println(str);
        }
    }
    public Digraph reverse(){
        int len = this.getNumNodes();
        Digraph reverse = new Digraph(len);
        for(int i=0;i<len;i++){
            for(int j: this.adj(i)){
                reverse.addEdge(j,i);
            }
        }
        return reverse;
    }

}
