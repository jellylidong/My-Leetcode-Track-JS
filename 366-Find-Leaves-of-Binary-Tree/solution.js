/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var findLeaves = function(root) {
    var ans = [];
    var helper = function(root){
        if(root === null)    return -1;
        let height = 1 + Math.max(helper(root.left), helper(root.right));
        if(height === ans.length) ans.push([]);
        ans[height].push(root.val);
        return height;
    }
    helper(root);
    return ans;
};