package dataStructure;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 二叉搜索树：
 * 每个节点中的值必须大于（或等于）存储在其左侧子树中的任何值；
 * 每个节点中的值必须小于（或等于）存储在其右子树中的任何值。
 *
 * 特点：
 * 中序遍历二叉搜索树可以得到一个递增的有序序列。
 * */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class BST {

    public boolean isValidBST(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        ArrayList<Integer> inOrder = new ArrayList<>();
        TreeNode current = root;
        while(current!=null||!stack.isEmpty()){
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            inOrder.add(current.val);
            current = current.right;
        }
        for(int i=1;i<inOrder.size();i++){
            if(inOrder.get(i)<=inOrder.get(i-1))return false;
        }
        return true;
    }
    public TreeNode insertIntoBST(TreeNode root, int val){
        if(root==null)return new TreeNode(val);
        TreeNode current = root;
        while(true){
            if(current.val>val){
                if(current.left==null){
                    current.left = new TreeNode(val);
                    break;
                }else current = current.left;

            }else{
                if(current.right==null){
                    current.right = new TreeNode(val);
                    break;
                }else current = current.right;
            }
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root,int key){
//        1、自己的想法，方法一
//        TreeNode current = root;
//        TreeNode pre = null;
//        while(current!=null&&current.val!=key){
//            pre = current;
//            if(key>current.val)current = current.right;
//            else current = current.left;
//        }
//        if(current==null)return root;
//
////       查看左右子树的情况
//        if(current.left==null){
//            if(null == pre){
//                root = current.right;
//                return root;
//            }else{
//                if(pre.left==current)pre.left = current.right;
//                else pre.right = current.right;
//                return root;
//            }
//        }
//        if(current.right==null){
//            if(null == pre){
//                root = current.left;
//                return root;
//            }else{
//                if(pre.left==current)pre.left = current.left;
//                else pre.right = current.left;
//                return root;
//            }
//        }
////        左右子树都不为空的情况,我们先找到该节点右侧最小节点，然后用后者覆盖前者的值，然后处理掉后面的节点（直接用temp = temp.right即可，这里很类似与大小堆的处理方式）
//        TreeNode temp = current.right;
//        pre = current;
//        while(temp.left!=null){
//            pre = temp;
//            temp = temp.left;
//        }
//        current.val = temp.val;
//        if(current==pre)pre.right = temp.right;
//        else pre.left = temp.right;
//        return root;
//          2、参考方法：递归
        if(root==null)return null;
        if(root.val>key)root.left = deleteNode(root.left,key);
        else if(root.val<key)root.right = deleteNode(root.right,key);
        else{
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            TreeNode temp = root.right;
            while(temp.left!=null){
                temp = temp.left;
            }
            temp.left = root.left;
            return root.right;
        }
        return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
//        1、存储父节点
//        HashSet<TreeNode> set = new HashSet<>();
//        LinkedList<TreeNode> stack = new LinkedList<>();
//        TreeNode current = root;
//        while(current!=null){
//            if(p.val>current.val){
//                set.add(current);
//                current = current.right;
//            }else if(p.val<current.val){
//                set.add(current);
//                current = current.left;
//            }else{
//                set.add(current);
//                break;
//            }
//        }
//        current = root;
//        while(current!=null){
//            if(q.val>current.val){
//                if(set.contains(current)){
//                    stack.push(current);
//               }
//                current = current.right;
//            }else if(q.val<current.val){
//                if(set.contains(current)){
//                    stack.push(current);
//                }
//                current = current.left;
//            }else{
//                if(set.contains(current)){
//                    stack.push(current);
//                }
//                break;
//            }
//        }
//        return stack.pop();
//      2、递归
//        if(root==null)return null;
//        if((root.val>=p.val&&root.val<=q.val)||(root.val<=q.val&&root.val>=p.val))return root;
//        else if(root.val<p.val)return lowestCommonAncestor(root.right,p,q);
//        else return lowestCommonAncestor(root.left,p,q);
//
        if(root==null)return null;
        TreeNode left = null,right = null;
        left = lowestCommonAncestor(root.left,p,q);
        right = lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null)return root;
        if((left!=null||right!=null)&&(p.val==root.val||q.val==root.val))return root;
        if(p.val==root.val||q.val==root.val)return root;
        if(left!=null)return left;
        if(left!=null)return right;
        return null;

    }


    class BSTIterator{
        private LinkedList<TreeNode> queue = new LinkedList<>();
        public BSTIterator(TreeNode root){
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode current = root;
            while(current!=null||!stack.isEmpty()){
                while(current!=null){
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                queue.offer(current);
                current = current.right;
            }
        }
        public boolean hasNext(){
            return !queue.isEmpty();
        }
        public int next(){
            return queue.poll().val;
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        TreeNode root = new TreeNode(0);
//        root.right = new TreeNode(2);
        bst.deleteNode(root,0);
    }

}

class KthLargest{
    private PriorityQueue<Integer> pq;
    private int k;
    public KthLargest(int k, int[] nums){
        this.k = k;
        LinkedList<Integer> list = new LinkedList<>();
        for(int i: nums){
            list.add(i);
        }
        pq = new PriorityQueue<>(list);
        while(pq.size()>k){
            pq.remove();
        }
    }
    public int add(int val){
       if(pq.size()<k) pq.add(val);
       else if(val>pq.peek()){
           pq.remove();
           pq.add(val);
       }
       return pq.peek();
    }


}
