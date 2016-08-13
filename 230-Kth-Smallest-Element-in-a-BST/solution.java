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
    int ans;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        ans = 0;
        count = k;
        helper(root);
        return ans;
    }
    
    public void helper(TreeNode root){
        if(root.left != null)   helper(root.left);
        count--;
        if(count == 0){
            ans = root.val;
            return;
        }
        if(root.right != null)  helper(root.right);
    }
}