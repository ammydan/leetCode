package dataStructure;

import java.util.HashMap;

/**
 * 双向链表尾部添加元素：（带tail 和 head)
 * node = new Node;
 * node.pre = tail.pre;
 * node.next = tail;
 * tail.pre.next = node;
 * tail.pre = node;
 *
 * 头部添加元素：
 * node = new Node;
 * node.next = head.next;
 * head.next.pre = node;
 * node.pre = head;
 * head.next = node;
 *
 * 删除某一个元素：
 * node.next.pre = node.pre;
 * node.pre.next = node.next;
 *
 *
 * 单向链表删除一个元素
 * pre.next = node.next;
 *
 * 单向链表添加一个元素
 * node.next = pre.next;
 * pre.next = node;
 *
 *  问题一：
 *  为什么使用双向链表：因为我们需要快速的删除我们用hashmap定位到的元素，单向链表还需要从头到尾遍历获取pre节点
 *  问题二：
 *  为什么链表中还要存储key：因为我们需要删除最不常使用的节点，如果链表中没有key的话，map中的节点无法删除。
 * */
public class LRU {
    private HashMap<Integer,Node>map;
    private DoubleList cache;
    private int cap;
    public LRU(int cap){
        this.cap = cap;
        this.map = new HashMap<>();
        this.cache = new DoubleList();
    }
    private void makeRecently(int key){
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }
    private void addRecently(int key,int val){
        Node node = new Node(key,val);
        cache.addLast(node);
        map.put(key,node);
    }
    private void deleteKey(int key){
        Node node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }
    private void removeLeastRecently(){
        Node deletedNode = cache.removeFirst();
        int deletedKey = deletedNode.key;
        map.remove(deletedKey);
    }
    public int get(int key){
        if(!map.containsKey(key))return -1;
        makeRecently(key);
        return map.get(key).val;
    }
    public void put(int key, int val){
        if(map.containsKey(key)){
            deleteKey(key);
            addRecently(key,val);
            return;
        }
        if(cap==cache.getSize()){
            removeLeastRecently();
        }
        addRecently(key,val);
    }

    public static void main(String[] args) {
        LRU test = new LRU(2);
        test.put(1,1);
        test.put(2,2);
        System.out.println(test.get(1));
        test.put(3,3);
        System.out.println(test.get(2));
        test.put(4,4);
        System.out.println(test.get(1));
        System.out.println(test.get(3));
        System.out.println(test.get(4));
    }
}
class Node{
    public int key, val;
    public Node pre, next;
    public Node(int k, int v){
        this.key = k;
        this.val = v;
    }
}
class DoubleList{
    private Node head, tail;
    private int size;

    public DoubleList(){
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = tail;
        this.tail.pre = head;
        this.size = 0;
    }

    public void addLast(Node x){
        x.pre = tail.pre;
        tail.pre.next = x;
        x.next = tail;
        tail.pre = x;
        size++;
    }
    public void remove(Node x){
        x.pre.next = x.next;
        x.next.pre = x.pre;
        size--;
    }
    public Node removeFirst(){
        if(head.next==tail)return null;
        Node first = head.next;
        remove(first);
        return first;
    }
    public int getSize(){
        return size;
    }
}