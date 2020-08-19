package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class TrieLink<Val> {
    private static final int R = 256;
    private Node root = new Node();
    private static class Node{
        private Object val;
        private Node[] next = new Node[R];
        public Node(){

        }
        public Node(Object val){
            this.val = val;
        }
    }
    public void put(String key, Val value){
        put(root,key,value,0);
    }
    private Node put(Node current, String key, Val value,int d){
        if(current==null)current = new Node();
        if(d==key.length()){
            current.val = value;
            return current;
        }
        char c = key.charAt(d);
        current.next[c] = put(current.next[c],key,value,d+1);
        return current;
    }
    public Val get(String key){
        Node temp = get(root,key,0);
        if(temp!=null)return (Val) temp.val;
        return null;
    }
    private Node get(Node current,String key, int d){
        if(current==null||d>key.length())return null;
        if(d==key.length())return current;
        return get(current.next[key.charAt(d)],key,d+1);
    }
    public void delete(String key){
        delete(root,key,0);
    }
    private Node delete(Node current, String key, int d){
        if(current==null)return null;
        if(d==key.length()){
            if(nullNext(current)) return null;
            current.val=null;
            return current;
        }
        char c = key.charAt(d);
        current.next[c] = delete(current.next[c],key,d+1);
        if(current.next[c]==null&&current.val==null&&nullNext(current))return null;
        return current;
    }
    private boolean nullNext(Node node){
        for(int i=0;i<R;i++){
            if(node.next[i]!=null)return false;
        }
        return true;
    }
    public Iterable<String> keys(){
        Queue<String>queue = new LinkedList<>();
        collect(root,"",queue);
        return queue;
    }
    private void collect(Node current, String prefix, Queue<String> queue){
        if(current==null)return;
        if(current.val!=null)queue.offer(prefix);
        int len = current.next.length;
        for(int i=0;i<len;i++){
            char c = (char) i;
            collect(current.next[i],prefix+c,queue);
        }
    }
    public Iterable<String> keyWithPrefix(String prefix){
        Queue<String> queue = new LinkedList<>();
        Node temp = get(root,prefix,0);
        collect(temp,prefix,queue);
        return queue;
    }

    public String longestPrefixOf(String query){
        int len = search(root,query,0,0);
        return query.substring(0,len);
    }
    private int search(Node current, String query, int d, int length){
        if(current==null)return length;
        if(current.val!=null) length = d;
        if(d==query.length())return length;
        char c = query.charAt(d);
        return search(current.next[c],query,d+1,length);
    }


    public static void main(String[] args) {
        TrieLink<Integer> test = new TrieLink<>();
        test.put("hello",3);
        test.put("her",4);
        test.put("hex",4);
        test.put("sofa",6);
        test.put("soft",7);
        test.put("haha",5);
        test.delete("hex");
        Iterable<String> it = test.keyWithPrefix("he");
        for(String str: it){
            System.out.println(str);
        }
    }

}
