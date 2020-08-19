package easy;
/**
 * 110 easy
 * 没啥好说的，递归就是干。
 * */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x){val = x;}
}
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root){
        int result = subtreeeHeight(root);
        if(result>=0)return true;
        return false;
    }
    private int subtreeeHeight(TreeNode current){
        if(current==null) return 0;
        int left = subtreeeHeight(current.left);
        int right = subtreeeHeight(current.right);
        if(left==-1||right==-1)return -1;
        if(Math.abs(left-right)<=1)return Math.max(left,right)+1;
        return -1;
    }
}
