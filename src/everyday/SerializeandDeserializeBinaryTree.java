package everyday;

import java.util.LinkedList;

/**
 * hard 297
 * 1、自己的思路
 * 这题原本就写了一遍，最开始的思路就是进行层序遍历的顺序，进行serialize。
 * 现在再做一遍是按照先序遍历的顺序进行执行。
 * */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class SerializeandDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
         if(root==null)return "null";
        StringBuilder ans = new StringBuilder();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while(!stack.isEmpty()||current!=null){
            while(current!=null){
                ans.append(current.val+",");
                stack.push(current);
                current = current.left;
            }
            ans.append("null,");
            current = stack.pop();
            current = current.right;
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         data = data.substring(0,data.length()-1);
         String [] list = data.split(",");
         if(list[0].equals("null"))return null;
         LinkedList<TreeNode> stack = new LinkedList<>();
         LinkedList<Boolean> flag = new LinkedList<>();
         TreeNode root = new TreeNode(Integer.parseInt(list[0]));
         stack.push(root);
         flag.push(false);
         int len = list.length;
         int i =1;
         while(i<len){
             TreeNode current;
             if(list[i].equals("null"))current = null;
             else current = new TreeNode(Integer.parseInt(list[i]));
             TreeNode pre = stack.peek();
             if(flag.pop()){
                 pre.right = current;
                 stack.pop();
             }else{
                 pre.left = current;
                 flag.push(true);
             }
             if(current!=null){
                 stack.push(current);
                 flag.push(false);
             }
             i++;
         }
         return root;

    }

    public static void main(String[] args) {
        SerializeandDeserializeBinaryTree test = new SerializeandDeserializeBinaryTree();
        String data = "1,2,null,null,3,4,null,null,5,null,null,";
        test.deserialize(data);

    }
}
