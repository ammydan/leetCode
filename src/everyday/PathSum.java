package everyday;

import java.util.LinkedList;
/**
 * 112 easy Path Sum
 * path sum 检测，而放在二叉树中的数据毫无规律可言，所以第一个判断就是需要全部遍历一遍才能知道这其中有没有相应的路径和。
 * 但是我们使用类似于前序遍历的时候，有一个问题就是当移除的时候我们可能这时候只是想进入右边分支，这个节点并不是想真正删除。
 * 所以这里参考了后序遍历的方法，第一次从栈中取出一个节点的时候，我们做一个标记，然后再放入栈中。
 * */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum){
        if(root==null)return false;
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Boolean> pass = new LinkedList<>();
        int tempSum = 0;
        TreeNode current = root;
        while(!stack.isEmpty()||current!=null){
            while(current!=null){
                stack.push(current);
                tempSum+=current.val;
                current = current.left;
                pass.push(false);
            }
            if(tempSum==sum)return true;
            while(!pass.isEmpty()&&pass.peek()){
                tempSum-=stack.pop().val;
                pass.pop();
            }
            if(!pass.isEmpty()&&!pass.peek()){
                current = stack.peek();
                pass.pop();
                pass.push(true);
                current = current.right;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PathSum test = new PathSum();
        TreeNode root = new TreeNode(1);
        test.hasPathSum(root,0);
    }
}
