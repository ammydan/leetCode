package dataStructure.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/**
 * 310 middle
 * 需要一点技巧，一直删除边缘点，最后留下来的两个点或者一个点则为中心。
 * */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges){
        LinkedList<Integer> ans = new LinkedList<>();
        if(n<=2){
            for(int i=0;i<n;i++){
                ans.add(i);
            }
            return ans;
        }
        int[] indegree = new int[n];
        HashSet<Integer>[] adjs = new HashSet[n];
        for(int i=0;i<n;i++){
            adjs[i] = new HashSet<>();
        }
        for(int[] node: edges){
            int x = node[0];
            int y = node[1];
            adjs[x].add(y);
            adjs[y].add(x);
            indegree[x]++;
            indegree[y]++;
        }

        LinkedList<Integer> list = new LinkedList<>();
        boolean[] marked = new boolean[n];
        for(int i=0;i<n;i++){
            if(indegree[i]==1)list.add(i);
        }
        int nums = n;
        while(n>2){
            LinkedList<Integer> temp = new LinkedList<>();
            for(int i: list){
                n--;
                marked[i] = true;
                if(indegree[i]<=0){
                    continue;
                }
                int adj = adjs[i].iterator().next();
                indegree[i]--;
                adjs[i].remove(adj);
                adjs[adj].remove(i);
                indegree[adj]--;
                if(indegree[adj]==1&&!marked[adj])temp.add(adj);
            }
            list = temp;
        }

        for(int i=0;i<nums;i++){
            if(!marked[i])ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumHeightTrees test = new MinimumHeightTrees();
        int[][] edges = {{1,0},{1,2},{1,3}};
        test.findMinHeightTrees(4,edges);
    }
}
