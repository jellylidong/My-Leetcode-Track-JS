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
        if(root === null)
            return 0;
        var left = helper(root.left);
        var right = helper(root.right);
        var level = Math.max(left, right);
        if(ans[level] === undefined)
            ans[level] = [];
        ans[level].push(root.val);
        return level+1;
    }
    helper(root);
    return ans;
};