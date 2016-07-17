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
var isValidBST = function(root) {
    var pre = null;
    var helper = function(root){
        if(root === null)
            return true;
        if(root.left === null && root.right === null){
            if(pre !== null && pre.val >=root.val)
                return false
            else{
                pre = root;
                return true;
            }
        }
        
        left = helper(root.left);
        if(left === false)  return false;
        if(pre !== null && pre.val >= root.val) return false;
        pre = root;
        right = helper(root.right);
        return right;
    }
    return helper(root);
};