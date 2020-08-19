package algorithm.recursive;

public class ValidateBinarySearchTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  public boolean isValidBST(TreeNode root){
        return helper(root,null,null);
  }
  private boolean helper(TreeNode current, Integer lower, Integer upper){
        if(current==null)return true;

        if(lower!=null&&current.val<=lower)return false;
        if(upper!=null&&current.val>=upper)return false;

        if(!helper(current.left,lower,current.val))return false;
        if(!helper(current.right,current.val,upper))return false;
        String t = "hell";
        t.hashCode();
        return true;
  }
}
