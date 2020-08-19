package everyday;

import java.util.LinkedList;
/**
 * 1028 hard
 * 1、自己的思路
 * 这道题其实不难，捋一下思路：额外一个记载堆栈中节点的深度，在不断的循环中进行修改。
 * 2、参考思路
 * 这里官方的解答中给出了一个更为巧妙的思路，就是记录路径，然后路径长度如果大于获取的深度，那么说明这个节点以及、、已经没有
 * 没有子节点，直接抛弃即可，然后不断比较长度直到比栈的长度大即可。
 * */
public class RecoveraTreeFromPreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode recoverFromPreorder(String s){
        if(s.length()<1)return null;
        StringBuilder str = new StringBuilder(s);
        LinkedList<Integer> depth = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(getNumber(str));
        stack.push(root);
        depth.push(0);
        while(str.length()>1){
            int dep = getDepth(str);
            int num = getNumber(str);
            while(depth.peek()>=dep){
                depth.pop();
                stack.pop();
            }
            TreeNode pre = stack.peek();
            TreeNode temp = new TreeNode(num);
            if(pre.left!=null)pre.right = temp;
            else pre.left = temp;
            stack.push(temp);
            depth.push(dep);
        }
        return root;
    }
    private int getNumber(StringBuilder s){
        if(s.length()<=0)return 0;
        int ans = 0;
        while(s.length()>0&&s.charAt(0)>='0'&&s.charAt(0)<='9'){
            int temp = s.charAt(0)-'0';
            s.deleteCharAt(0);
            ans = ans*10+temp;
        }
        return ans;
    }
    private int getDepth(StringBuilder s){
        if(s.length()==0)return 0;
        int ans = 0;
        while(s.length()>0&&s.charAt(0)=='-'){
            ans++;
            s.deleteCharAt(0);
        }
        return ans;
    }
}
