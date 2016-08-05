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
    List<List<Integer>> ans;
    public List<List<Integer>> findLeaves(TreeNode root) {
        //a tree node's level is the max height count from its leafs
        
        ans = new ArrayList<>();
        helper(root);
        return ans;
    }
    
    public int helper(TreeNode root){
        if(root == null)    return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int level = Math.max(left, right);
        if(ans.size() <= level){
            for(int i = ans.size(); i <= level; i++)
                ans.add(new ArrayList<Integer>());
        }
        ans.get(level).add(root.val);
        return level+1;
    }
}