package algorithm.recursive;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTrees2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<TreeNode> generateTrees(int n){
        if(n<=0)return new LinkedList<>();
        return helper(1,n);

    }
    private List<TreeNode> helper(int start, int end){
        LinkedList<TreeNode> list = new LinkedList<>();
        if(start>end)return list;
        for(int i=start;i<=end;i++){
            LinkedList<TreeNode> left = (LinkedList<TreeNode>) helper(start,i-1);
            LinkedList<TreeNode> right = (LinkedList<TreeNode>) helper(i+1,end);
            for(TreeNode x:left){
                for(TreeNode y:right){
                    TreeNode temp = new TreeNode(i);
                    temp.left = x;
                    temp.right = y;
                    list.add(temp);
                }
            }
        }
        return list;
    }
}
