package dataStructure.graph;

import java.util.*;

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node){
        Node NG = new Node(node.val);
        HashMap<Integer,Node> map = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        LinkedList<Node> que = new LinkedList<>();
        queue.offer(node);
        que.offer(NG);
        map.put(node.val,NG);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            Node nCurrent = que.poll();
            ArrayList<Node> nNeighbors = new ArrayList<>();
            nCurrent.neighbors = nNeighbors;
            for(Node n: current.neighbors){
                Node temp = new Node(n.val);
                if(map.containsKey(n.val)){
                    nCurrent.neighbors.add(map.get(n.val));
                    continue;
                }else{
                    queue.add(n);
                    que.add(temp);
                    nCurrent.neighbors.add(temp);
                    map.put(n.val,temp);
                }
            }
        }
        return NG;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        ArrayList<Node> list = new ArrayList();
        list.add(node2);
        list.add(node4);
        node1.neighbors = list;
        list = new ArrayList();
        list.add(node1);
        list.add(node3);
        node2.neighbors = list;
    }
}
