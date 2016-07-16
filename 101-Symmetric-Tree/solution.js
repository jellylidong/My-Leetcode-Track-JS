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
    if(root === null)
        return true;
    var helper = function(p, q){
        if(p === null && q === null)
            return true;
        if((p === null && q !== null) || (p !== null && q === null))
            return false;
        if(p.val != q.val)
            return false;
        return helper(p.left, q.right) && helper(p.right, q.left);
    }
    return helper(root.left, root.right);
};