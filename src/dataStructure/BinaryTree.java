package dataStructure;

import sun.awt.image.ImageWatched;

import java.util.*;


/***
 * Definition:
 *A binary tree is a tree such that
 * every node has at most 2 children
 * each node is labeled as being either a left child or a right child.
 *
 * Terminology:
 * 路径(path)：从一个节点走到另一个节点，所经过的节点的顺序排列就称为“路径”
 * 根(root)：树的顶端称为“根”。一棵树只有一个根，所有节点都只有一条到根的路径。
 * 子节点(child node)：每个节点都有可能有一条或者多条向下连接其他节点。
 * 叶子节点(leaves node)：没有子节点的节点。
 * 子树(subtree)：每个节点都可以作为“子树”的根。
 * 遍历(traverse)：遍历树以为这要遵循某种特定的顺序访问树中的所有节点。
 * 层(layer)：一个节点的层数是指从根开始到这个节点有多少“代”。
 *
 * ADT：
 * root; size;
 * Node{
 *     left; right;
 *     data;
 * }
 * find(key)
 * insert(key,data)
 * delete(key)
 * size()
 * isEmpty()
 * parent(node)
 * children(node)
 * isInternal(node)
 * isExternal(node)
 * ***/
public class BinaryTree <T>{
    private int size;
    private Node root;
    public BinaryTree(){
        size = 0;
    }
    public BinaryTree(T data){
        root = new Node(data);
        size = 1;
    }

    private class Node{
        private T data;
        private Node right;
        private Node left;
        public Node(){

        }
        public Node(T data){
            this.data = data;
        }
        public Node(T data, Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    /****
     * 遍历顺序：
     * 1、前序遍历
     * *****/
    public List<T> preorderTraversal(){
        LinkedList<Node> stack = new LinkedList<>();
        List<T> ans = new LinkedList<>();
        Node current=root;
        while(!stack.isEmpty()||current!=null){
            while(current!=null){
                ans.add(current.data);
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;

        }
        return ans;
    }
    /****
     * 遍历顺序：
     * 2、中序遍历
     * *****/
    public List<T> inorderTraversal(){
        LinkedList<Node> stack = new LinkedList<>();
        List<T> ans = new LinkedList<>();
        Node current = root;
        while(!stack.isEmpty()||current!=null){
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            ans.add(current.data);
            current = current.right;
        }
        return ans;
    }
    /****
     * 遍历顺序：
     * 3、中序遍历
     * *****/
    public List<T> postorderTraversal(){
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Boolean> flag = new LinkedList<>();
        List<T> ans = new LinkedList<>();
        Node current = root;
        while(!stack.isEmpty()||current!=null){
            while(current!=null){
                stack.push(current);
                flag.push(false);
                current = current.left;
            }
            while(!stack.isEmpty()&&flag.peek()){
                current = stack.pop();
                ans.add(current.data);
                flag.pop();
            }
            if(!stack.isEmpty()&& !flag.peek()){
                current = stack.peek();
                flag.pop();
                flag.push(true);
                current = current.right;
            }
        }
        return ans;
    }
    /***
     * 遍历顺序
     * 4、层次遍历
     * ***/
    public List<List<T>> levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        List<List<T>> ans = new LinkedList<>();
        if(root == null)return ans;
        queue.offer(root);
        while(!queue.isEmpty()){
            List<T> temp = new LinkedList<>();
            Queue<Node> tempQue = new LinkedList<>();
            while(!queue.isEmpty()){
                Node node = queue.poll();
                tempQue.offer(node);
                temp.add(node.data);
            }
            if(!temp.isEmpty()) ans.add(temp);
            while(!tempQue.isEmpty()){
                Node node = tempQue.poll();
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
            }
        }
        return ans;
    }

    /***
     * 获取最大层次
     * **/
    public int maxDepth(){
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> backQue = new LinkedList<>();
        int max = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            max++;
            while(!queue.isEmpty()){
                backQue.offer(queue.poll());
            }
            while(!backQue.isEmpty()){
                Node tmp = backQue.poll();
                if(tmp.left!=null)queue.offer(tmp);
                if(tmp.right!=null)queue.offer(tmp);
            }
        }
        return max;
    }

    /**
     * 检测树是否平衡
     * ***/
    public boolean isSymmetric(){
        if(root==null)return true;
        Node left = root.left;
        Node right = root.right;
        Queue<Node> queueL = new LinkedList<>();
        Queue<Node> queueR = new LinkedList<>();
        if(left==null&&right!=null)return false;
        if(left!=null&&right==null)return false;
        if(left==null&&right==null)return true;
        if(left.data!=right.data)return false;
        queueL.offer(left);
        queueR.offer(right);
        while(!queueL.isEmpty()){
            Node tmpL = queueL.poll();
            Node tmpR = queueR.poll();
            int state = isEqual(tmpL.left,tmpR.right);
            if(state==-1)return false;
            if(state==1){
                queueL.offer(tmpL.left);
                queueR.offer(tmpR.right);
            }
            state = isEqual(tmpL.right,tmpR.left);
            if(state==-1)return false;
            if(state==1){
                queueL.offer(tmpL.right);
                queueR.offer(tmpR.left);
            }
        }
        return true;

    }
    private int isEqual(Node a, Node b){
        if(a==null&&b!=null)return -1;
        if(a!=null&&b==null)return -1;
        if(a==null&&b==null)return 0;
        if(a.data!=b.data)return -1;
        return 1;
    }

    /***
     *路径总和，因为我这里是泛型，所以这里会报错
     * ****/
//    public boolean hasPathSum(int sum){
//        if(root==null)return false;
//         LinkedList<Node> traversal = new LinkedList<>();
//        LinkedList<Integer> allSum = new LinkedList<>();
//         traversal.push(root);
//         allSum.push(root.data);
//         while(!traversal.isEmpty()){
//             Node node = traversal.pop();
//             int theSum = allSum.pop();
//             if(node.left==null&&node.right==null){
//                 if(theSum==sum)return true;
//             }
//             if(node.left!=null){
//                 allSum.push(theSum+node.left.data);
//                 traversal.push(node.left);
//             }
//             if(node.right!=null){
//                 allSum.push(theSum+node.left.data);
//                 traversal.push(node.right);
//             }
//         }
//         return false;
//    }
    /**
     *中序遍历+后序遍历构建树
     * */
    public Node buildTreeInPost(T[] inOrder, T[] postOrder){
        HashMap<T,Integer> inOrderMap = new HashMap<>();
        if(inOrder.length<=0)return null;
        for(int i=0;i<inOrder.length;i++){
            inOrderMap.put(inOrder[i],i);
        }
        root = buildTree(0,inOrder.length,0,inOrder.length,postOrder,inOrderMap);
        return root;
    }
    private Node buildTree(int inL,int inR,int postL,int postR,T[] postOrder,HashMap<T,Integer> map){
        if(inL>inR)return null;
        if(postL>postR)return null;
        T val = postOrder[postR];
        int index = map.get(val);
        Node tmp = new Node(val);
        tmp.left = buildTree(inL, index-1,postL,postL+index-inL-1,postOrder, map);
        tmp.right = buildTree(index+1, inR,postL+index-inL,postR-1,postOrder, map);
        return tmp;
    }
    /**
     * 前序遍历+中序遍历构建树
     * */
    public Node buildTreePrePost(T[]preOrder, T[]inOrder){
        HashMap<T,Integer> map = new HashMap<>();
        for(int i=0;i<inOrder.length;i++){
            map.put(inOrder[i],i);
        }
        Node root = buildTreePP(0,preOrder.length-1,0,inOrder.length-1,preOrder,map);
        return root;
    }
    private Node buildTreePP(int preL,int preR,int postL,int postR,T[] preOrder,HashMap<T, Integer>map){
        if(preL>preR)return null;
        if(postL>postR)return null;
        T val = preOrder[preL];
        int index = map.get(val);
        Node current = new Node(val);
        current.left = buildTreePP(preL+1,preL+index-postL,postL,index-1,preOrder,map);
        current.right = buildTreePP(preL+1+index-postL,preR,index+1,postR,preOrder,map);
        return current;
    }
    /**
     * 序列化和反序列化
     * */
    public String serialize(){
        if(root==null)return null;
        LinkedList <T> serial = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node tmp = queue.poll();
            if(tmp==null){
                serial.add(null);
                continue;
            }
            serial.add(tmp.data);
            queue.offer(tmp.left);
            queue.offer(tmp.right);
        }
        return serial.toString();
    }
//    public boolean deserialize(String str){
//        str = str.substring(1,str.length()-1);
//        String[] list = str.split(",");
//        String tmp = list[0];
//        if(tmp.equals("null")){
//            root =null;
//            return true;
//        }
//        else{
//            Integer.parseInt(tmp);
//        }
//    }
    public static void main(String[] args) {
//       LinkedList <Integer> array = new LinkedList<>();
//       array.add(-1);
//       array.add(null);
//       array.add(2);
//       String str = array.toString();
//       System.out.println(str);
        Object[] objects = new Object[2];
        String str = "nhios";
        System.out.println(objects[0]);
    }
}
