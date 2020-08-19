package everyday;

import java.util.LinkedList;
import java.util.List;
/**
 * middle 95
 * */
public class UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n){
        if(n<=0)return new LinkedList<>();
        return helper(1,n);
    }
    private List<TreeNode> helper(int left, int right){
        List<TreeNode> list = new LinkedList<>();
        if(right<left){
            list.add(null);
            return list;
        }
        for(int i = left;i<=right;i++){
            List<TreeNode> leftNodes = helper(left,i-1);
            List<TreeNode> rightNodes = helper(i+1,right);
            for(TreeNode x: leftNodes){
                for(TreeNode y: rightNodes){
                    TreeNode mid = new TreeNode(i);
                    mid.left = x;
                    mid.right = y;
                    list.add(mid);
                }
            }
        }
        return list;
    }
}
