/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
 
 /*my analysis
 * the basic idea is find the max left sub tree, find the max right sub tree
 * since the node.val can be negative
 * the the final max sum can be in any sub tree
 * so we need to update max value in every recursion*/
var maxPathSum = function(root) {
    var max = Number.NEGATIVE_INFINITY;
    
    var helper = function(root, curSum){
        if(root === null)   return curSum;
        var left = Math.max(0, helper(root.left, curSum));
        var right = Math.max(0, helper(root.right, curSum));
        
        max = Math.max(max, left + root.val + right);
        
        return root.val + Math.max(left, right);
    }
    
    helper(root, 0);
    return max;
};