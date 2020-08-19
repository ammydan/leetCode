package dataStructure.graph;

import java.util.Iterator;
import java.util.LinkedList;
/**
 * 207 middle
 * 这道题注重在有向图的环探测，不能按照无向图的那种方法进行了。！！！！！
 * */
public class CourseSchedule {
    private int size;
    private LinkedList<Integer> adj[];
    private int[]marked;
    private boolean valid = true;

    private void add(int x, int y){
        adj[x].add(y);
    }
    private Iterable<Integer> adj(int x){
        return  adj[x];
    }
    public boolean canFinish(int numCourses, int[][]prerequisites){
        this.size = numCourses;
        this.adj = new LinkedList[size];
        this.marked = new int[size];
        for(int i=0;i<size;i++){
            adj[i] = new LinkedList<>();
        }
        for(int[] pairs:prerequisites){
            add(pairs[0],pairs[1]);
        }
        for(int i = 0;i<size;i++){
            dfs(i);
        }
        return valid;
    }
    public void dfs(int current){
        marked[current] = 1;
        for(int i: adj[current]){
            if(marked[i]==1){
                valid = false;
                return ;
            }else if(marked[i] ==0){
                dfs(i);
            }
        }
        marked[current] = 2;
    }
}
