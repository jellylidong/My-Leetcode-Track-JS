/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isSymmetric = function(root) {
    if(root === null)   return true;
    var helper = function(r1, r2){
        if(r1 === null && r2 === null)  return true;
        if(r1 === null && r2 !== null)  return false;
        if(r1 !== null && r2 === null)  return false;
        if(r1.val != r2.val)    return false;
        return helper(r1.left, r2.right) && helper(r1.right, r2.left); 
    }
    return helper(root.left, root.right);
};