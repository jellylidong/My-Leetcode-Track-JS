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
var minDepth = function(root) {
    var min = Number.MAX_VALUE;
    
    var helper = function(root, cur){
        if(root === null)   return;
        if(cur >= min)  return;
        if(root.left === null && root.right === null)
            min = Math.min(min, cur);
        helper(root.left, cur+1);
        helper(root.right, cur+1);
    }
    
    helper(root, 1);
    return min == Number.MAX_VALUE? 0:min;
};