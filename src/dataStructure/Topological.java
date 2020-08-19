package dataStructure;

import java.util.LinkedList;
import java.util.List;

public class Topological {
    private LinkedList<Integer> reverseOrder;
    private boolean[]marked;
    public Topological(Digraph g){
        reverseOrder = new LinkedList<>();
        int len = g.getNumNodes();
        marked = new boolean[len];
        for(int i=0;i<len;i++){
            if(!marked[i]){
                dfs(g,i);
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        for(int i: reverseOrder){
            list.push(i);
        }
        reverseOrder = list;

    }
    private void dfs(Digraph g,int current){
        marked[current] = true;
        for(int i: g.adj(current)){
            if(!marked[i])dfs(g,i);
        }
        reverseOrder.add(current);
    }
    public Iterable<Integer> reversePostOrder(){
        return reverseOrder;
    }

    public static void main(String[] args) {
        Digraph g = new Digraph(13);
        g.addEdge(0,1);
        g.addEdge(0,5);
        g.addEdge(6,0);
        g.addEdge(2,3);
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
        Topological test = new Topological(g);
        List<Integer> list = test.reverseOrder;
        for(int i: list){
            System.out.println(i);
        }
    }
}
