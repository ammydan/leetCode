package dataStructure;

public class RedBlackTree<T extends Comparable> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node head;
    class Node{
        private Node left;
        private Node right;
        private T value;
        private boolean red;
        public Node(){
            red = false;
        }
        public Node (boolean red){
            this.red = red;
        }
        public Node(T value,boolean red){
            this.value = value;
            this.red = red;
        }
    }


    private boolean isRed(Node node){
        if(node == null)return false;
        return node.red;
    }
    private Node rotateRight(Node node){
        if(node==null||node.left==null)return node;
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        boolean tempRed = node.red;
        node.red = temp.red;
        temp.red = tempRed;
        return temp;
    }
    private Node rotateLeft(Node node){
        if(node==null||node.right==null)return node;
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        boolean tempRed = node.red;
        node.red = temp.red;
        temp.red = tempRed;
        return temp;
    }
    private Node flipColor(Node node){
        if(node==null||node.left==null||node.right==null)return node;
//        if(node.red||!node.left.red||!node.right.red)return node;
        node.red = !node.red;
        node.left.red = !node.left.red;
        node.right.red = !node.right.red;
        return node;
    }

    public void insert(T value){
        if(head ==null){
            head = new Node(value,BLACK);
            return;
        }
        head = insert(value,head);
        head.red = BLACK;
    }
    private Node insert(T value, Node current){
        if(current==null)return new Node(value,RED);
        if(current.value.compareTo(value)>0)current.left = insert(value,current.left);
        else if(current.value.compareTo(value)<0)current.right = insert(value,current.right);
        else current.value = value;

        if(isRed(current.right)&&!isRed(current.left))current = rotateLeft(current);
        if(isRed(current.left)&&isRed(current.left.left))current = rotateRight(current);
        if(isRed(current.left)&&isRed(current.right))current = flipColor(current);
        return current;

    }
    public boolean search(T value){
        Node current = head;
        while(current!=null){
            if(current.value.compareTo(value)>0)current = current.left;
            else if(current.value.compareTo(value)<0)current = current.right;
            else return true;
        }
        return false;
    }


    private Node moveRedRight(Node node){
        node = flipColor(node);
        if(isRed(node.left)&&isRed(node.left.left)){
            node = rotateRight(node);
            node = flipColor(node);
        }
        return node;
    }
    private Node fixUp(Node node){
        if(isRed(node.right)) node = rotateLeft(node);
        if(isRed(node.left)&&isRed(node.left.left))node = rotateRight(node);
        if(isRed(node.left)&&isRed(node.right))node = flipColor(node);
        return node;
    }
    public void deleteMax(){
        head = deleteMax(head);
        head.red = BLACK;
    }
    private Node deleteMax(Node current){
        if(current==null)return null;
        if(isRed(current.left))current = rotateRight(current);
        if(current.right==null)return null;
        if(!isRed(current.right)&&!isRed(current.right.left))current = moveRedRight(current);
        current.right = deleteMax(current.right);
        return fixUp(current);
    }
    public void deleteMin(){
        head = deleteMin(head);
        head.red = BLACK;
    }

    private Node deleteMin(Node current){
        if(current==null)return null;
        if(current.left==null)return null;
        if(!isRed(current.left)&&!isRed(current.left.left))current = moveRedLeft(current);
        current.left = deleteMin(current.left);
        return fixUp(current);

    }
    private Node moveRedLeft(Node node){
        node = flipColor(node);
        if(isRed(node.right.left)){
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
            node = flipColor(node);
        }
        return node;

    }
    public T min(){
        Node ans = min(head);
        if(ans==null)return null;
        return ans.value;
    }
    private Node min(Node node){
        if(node==null)return null;
        Node current = node;
        while(current.left!=null){
            current = current.left;
        }
        return current;
    }
    public void delete(T value){
        head = delete(head,value);
        head.red = BLACK;
    }

    private Node delete(Node current,T value){
        if(current==null)return null;
        if(current.value.compareTo(value)>0){
            if(!isRed(current.left)&&!isRed(current.left.left))current = moveRedLeft(current);
            current.left = delete(current.left,value);
        }
        else {
            if(isRed(current.left))current = rotateRight(current);
            if(current.value.compareTo(value)==0&&current.right==null)return null;
            if(!isRed(current.right)&&!isRed(current.right.left))current = moveRedRight(current);
            if(current.value.compareTo(value)==0){
                Node min = min(current.right);
                current.value = min.value;
                current.right=deleteMin(current.right);
            }else current.right = delete(current.right,value);

        }
        return fixUp(current);
    }

    public static void main(String[] args) {
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        rbt.insert(2);
        rbt.insert(5);
        rbt.insert(7);
        rbt.insert(23);
        rbt.insert(14);
        System.out.println(rbt.min());
        rbt.deleteMin();
        System.out.println(rbt.min());
        rbt.insert(10);
        rbt.delete(7);
    }

}
