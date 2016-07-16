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

var isValidBST = function(root){
    var cur = root;
    var pre = null;
    var isValidBST_Recursion_Helper = function(root) {
        if (root === null) {
            return true;
        }
        if (root.left === null && root.right === null) {
            if (pre !== null && pre.val >= root.val) {
                return false;
            }
            else {
                pre = root;
                return true;
            }
    
        }
    
        left = isValidBST_Recursion_Helper(root.left);
        if (!left) {
            return false;
        }
        if (pre !== null && pre.val >= root.val)
            return false;
        pre = root;
        right = isValidBST_Recursion_Helper(root.right);
        return right;
    }
    return isValidBST_Recursion_Helper(cur);
}
