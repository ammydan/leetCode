package dataStructure.graph;

import java.util.LinkedList;
/**
 * 210 middle
 * */
public class CourseSchedule2 {
    private int size;
    private LinkedList<Integer> adj[];
    private int[]marked;
    private boolean valid = true;
    private int[] ans;
    private LinkedList<Integer> order;

    private void add(int x, int y){
        adj[x].add(y);
    }
    private Iterable<Integer> adj(int x){
        return  adj[x];
    }
    public int[] findOrder(int numCourses, int[][]prerequisites){
        this.size = numCourses;
        ans = new int[size];
        order = new LinkedList<>();
        this.adj = new LinkedList[size];
        this.marked = new int[size];
        for(int i=0;i<size;i++){
            adj[i] = new LinkedList<>();
        }
        for(int[] pairs:prerequisites){
            add(pairs[1],pairs[0]);
        }
        for(int i = 0;i<size;i++){
            if(marked[i]!=0) continue;
            dfs(i);
            if(!valid)return new int[0];
        }
        int index = 0;
        while(!order.isEmpty()){
            ans[index++] = order.pop();
        }
        return ans;
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
        order.push(current);
    }

    public static void main(String[] args) {
        CourseSchedule2 test = new CourseSchedule2();
        int[][] list = {{1,0},{0,1}};
        test.findOrder(2,list);
    }
}
