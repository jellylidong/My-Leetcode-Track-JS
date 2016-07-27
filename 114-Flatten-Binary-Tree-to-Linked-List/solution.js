/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
var flatten = function(root) {
    //preorder
    var pre = null;
    var helper = function(root){
        if(root === null) return null;
        var left = root.left;
        var right = root.right;
        root.left = null;
        if(left !== null)
            root.right = helper(left);
        else
            pre = root;
        pre.right = helper(right);
        return root;
    };
    
    helper(root);
};