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
    //note!!! Number.MIN_VALUE in JS is the smallest POSITIVE float number
    
    var maxSub = function(root){
                // console.log(max);

        if(root === null)    return 0;
        // console.log(root.val)
        var left = Math.max(0, maxSub(root.left));
        // console.log(left + " " + typeof left);
        var right = Math.max(0, maxSub(root.right));
        // console.log(right);
        // console.log("sum = " + (left+right+root.val))
        // console.log("premax = " + max);
        max = Math.max(max, left+right+root.val);
        // console.log("postmax = " + max);
        // console.log("max = " + max);
        return root.val + Math.max(left, right);
    }
    maxSub(root);
    return max;
};