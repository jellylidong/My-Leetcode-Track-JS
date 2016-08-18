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
    public int longestConsecutive(TreeNode root) {
        //sequence that is from parent to children and increasing
        max = 0;
        if(root != null)
            helper(root, 1);
        return max;
    }
    
    public void helper(TreeNode root, int curLen){
        
        max = Math.max(max, curLen);
        
        if(root.left != null){
            if(root.left.val == root.val+1)  helper(root.left, curLen+1);
            else    helper(root.left, 1);
        }
        
        
        if(root.right != null){
            if(root.right.val == root.val+1)    helper(root.right, curLen+1);
            else    helper(root.right, 1);
        }
        
    }
}