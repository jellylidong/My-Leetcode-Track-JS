/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number} n
 * @return {TreeNode[]}
 */
var generateTrees = function(n) {
    if(n === 0) return null;
    
    var copy = function(root, offset){
        if(root === null)   return null;
        var newRoot = new TreeNode(root.val + offset);
        newRoot.left = copy(root.left, offset);
        newRoot.right = copy(root.right, offset);
        return newRoot;
    }
    
    var map = new Map();
    map.set(0,[null]);
    
    for(let i = 1; i <= n; i++){
        var curList = [];
        for(let j = 1; j <= i; j++){
            var left = map.get(j-1);
            var right = map.get(i-j)
            for(let m = 0; m < left.length; m++){
                for(let n = 0; n < right.length; n++){
                    var root = new TreeNode(j);
                    root.left = copy(left[m], 0);
                    root.right = copy(right[n], j);
                    curList.push(root);
                }
            }
        }
        map.set(i, curList);
    }
    
    return map.get(n);
};