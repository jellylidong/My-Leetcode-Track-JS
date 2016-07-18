/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
    	max = Integer.MIN_VALUE;
    	maxSub(root);
    	return max;
    }
    
    private int maxSub(TreeNode root){
    	if(root == null)
    		return 0;
    	int left = Math.max(0, maxSub(root.left));
    	int right = Math.max(0, maxSub(root.right));
    	max = Math.max(max, left+root.val+right);
    	return Math.max(left, right) + root.val;
    }
}