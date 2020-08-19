package everyday;
/**
 * easy 108
 * 每次选择中间的即可，而且直接递归。
 * */
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums){
        return helper(nums,0,nums.length);
    }
    private TreeNode helper(int[] nums, int left, int right){
        if(right-left<1)return null;
        int mid = left+(right-left)/2;
        TreeNode current = new TreeNode(nums[mid]);
        current.left = helper(nums,left,mid);
        current.right = helper(nums,mid+1,right);
        return current;
    }
}
