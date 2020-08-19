package dataStructure.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class RedundantConnection {
    class UF{
        private int[] list;
        private int[] size;
        private int len;
        public UF(int len){
            this.len = len;
            this.list = new int[len];
            this.size = new int[len];
            Arrays.fill(this.size,1);
            for(int i=0;i<len;i++){
                list[i] = i;
            }
        }
        private int root(int x){
            while(x!=list[x]){
                list[x] = list[list[x]];
                x= list[x];
            }
            return x;
        }
        public boolean connected(int x, int y){
            if(x==y)return true;
            int rootX = root(x);
            int rootY = root(y);
            return rootX==rootY;
        }
        public void union(int x, int y){
            if(x==y)return;
            int rootX = root(x);
            int rootY = root(y);
            int sizeX = size[rootX];
            int sizeY = size[rootY];
            if(sizeX>sizeY){
                list[rootX] = rootY;
                size[rootY] = sizeX+sizeY;
            }else{
                list[rootY] = rootX;
                size[rootX] = sizeX+sizeY;
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges){
        int max = 0;
        HashMap<Integer,Integer> indegree = new HashMap<>();
        HashMap<Integer, LinkedList<Integer>> inputEdge = new HashMap<>();
        int candidate = -1;
        HashSet<Integer> set = new HashSet<>();
        for(int[]node:edges){
            int x = node[0];
            int y = node[1];
            indegree.put(y,indegree.getOrDefault(y,0)+1);
            LinkedList<Integer> tempList = inputEdge.getOrDefault(y,new LinkedList<>());
            tempList.add(x);
            if(tempList.size()==2)candidate = y;
            inputEdge.put(y,tempList);
            if(!set.contains(x)) {
                set.add(x);
                max++;
            }
            if(!set.contains(y)){
                set.add(y);
                max++;
            }
        }
        int [] ans = new int[2];
        LinkedList<Integer> temp = inputEdge.get(candidate);
        if(temp==null||temp.size()<=1){
            UF uf = new UF(max+1);
            for(int[] edge:edges){
                if(uf.connected(edge[0],edge[1])){
                    ans[0] = edge[0];
                    ans[1] = edge[1];
                    return ans;
                }else{
                    uf.union(edge[0],edge[1]);
                }
            }
        }
        boolean flag = false;
        for(int i =1;i>=0;i--){
            if(valid(candidate,temp.get(i),inputEdge)){
                ans[0] = temp.get(i);
                ans[1] = candidate;
                flag = true;
            }
        }
        if(!flag){
            ans[0] = temp.get(1);
            ans[1] = candidate;
        }
        return ans;
    }
    private boolean valid(int start, int x,HashMap<Integer,LinkedList<Integer>>map){
        int i =x;
        while(true){
            if(i==start)break;
            LinkedList<Integer>list = map.get(i);
            if(list==null){
                i=-1;
                break;
            }
            i = list.get(0);
        }
        return i==start;
    }

    public static void main(String[] args) {
        RedundantConnection test = new RedundantConnection();
//        int[][] list = {{1,2},{1,3},{2,3}};
        int[][] list = {{2,1},{3,1},{4,2},{1,4}};
        test.findRedundantConnection(list);
//        System.out.println(0xA<<2);
    }
}
