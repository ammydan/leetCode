package everyday;

/**
 * 124 hard
 * 这道题是一个比较简单的hard题。
 * 1、自己的想法：
 * 最大路径和，猛然就想起来DP中求连续最大和，这种题目的要求不仅要求最大，而且要求连续。回想DP中求解这种题目的方式。
 * 必定是，在i位置上，我加不加前面的sum取决于前面的sum是否对我有助力，如果我加上前面的sum反而是我减小那么我宁愿从我这里断绝与前面的联系。
 * 当然这里需要max记录最大值，因为连续累加可能后面会变小。
 * 回归到这道题，一个点的路径可以选择从左子树到自己再到父节点，也可以从右子树到自己再到父节点，这里传递给父节点的点要做一个大小比较。
 * 然后我也可以直接从我这里中断左右节点都加上作为一个最大SUM的候选值（也就是比DP那道题多了一个选择，毕竟有了两个分支）
 * ①该节点要先获取左右子树的传递来的值，如果为null则为0。
 * ②加上左右节点的值（加大于零的）和ans比较，如果比ans大就交给
 * * */
public class BinaryTreeMaximumPathSum {
    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        helper(root);
        return ans;
    }
    private int helper(TreeNode current){
        int left=0,right=0,value=0;
        if(current.left!=null)left = helper(current.left);
        if(current.right!=null)right = helper(current.right);
        if(left>0)value +=left;
        if(right>0)value +=right;
        value+=current.val;
        if(value>ans) ans = value;
        value = left>right?left:right;
        if(value<0)value = 0;
        value+=current.val;
        return value;
    }
}
