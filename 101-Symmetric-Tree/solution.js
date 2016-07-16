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
        
    //recursion    
    // var helper = function(p, q){
    //     if(p === null && q === null)
    //         return true;
    //     if((p === null && q !== null) || (p !== null && q === null))
    //         return false;
    //     if(p.val != q.val)
    //         return false;
    //     return helper(p.left, q.right) && helper(p.right, q.left);
    // }
    // return helper(root.left, root.right);
    
    //iteraion
    var queue = [];
    queue.push(root.left);
    queue.push(root.right);
    while(queue.length > 0){
        p = queue.shift();
        q = queue.shift();
        if(p === null && q === null)
            continue;
        if((p === null && q !== null) || (p !== null && q === null))
            return false;
        if(p.val != q.val)
            return false;
        queue.push(p.left);
        queue.push(q.right);
        queue.push(p.right);
        queue.push(q.left);
    }
    return true;
};