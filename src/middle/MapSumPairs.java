package middle;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
/**
 * midlle 677
 * 没什么好说的，前缀树走起。
 * */
public class MapSumPairs {
    class Node{
        private HashMap<Character, Node> subtree;
        private int val;
        public Node(int val){
            subtree = new HashMap<>();
            this.val = val;
        }
    }
    private Node root;
    public MapSumPairs(){
        root = new Node(0);
    }
    public void insert(String key, int val){
        insert(root,key,val,0);
    }
    private Node insert(Node current, String key, int val,int d){
        if(current == null) current = new Node(0);
        if(d==key.length()){
            current.val = val;
            return current;
        }
        char c = key.charAt(d);
        if(!current.subtree.containsKey(c))current.subtree.put(c,insert(null,key,val,d+1));
        insert(current.subtree.get(c),key,val,d+1);
        return current;

    }
    public int sum(String prefix){
        Node start = startsWith(root,prefix,0);
        if(start==null)return 0;
        int ans = 0;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            ans+=current.val;
            Collection<Node> list =  current.subtree.values();
            for(Node i: list){
                queue.offer(i);
            }
        }
        return ans;
    }
    private Node startsWith(Node current, String key, int d){
        if(current==null||d>key.length())return null;
        if(d==key.length())return current;
        char c = key.charAt(d);
        return startsWith(current.subtree.get(c),key, d+1);
    }
}
