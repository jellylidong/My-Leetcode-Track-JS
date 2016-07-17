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
var maxDepth = function(root) {
    // if(root === null)   return 0;
    var max = 0;
    var helper = function(root, cur){
        if(root === null)   return;
        if(root.left === null && root.right === null){
            max = Math.max(max, cur);
        }
        else{
            // if(root.left !=== null)     
                helper(root.left, cur+1);
            // if(root.right !=== null)    
                helper(root.right, cur+1);
        }
    }
    helper(root, 1);
    return max;
};