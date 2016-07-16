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
// var pre = null;
var isValidBST = function(root) {
    // if(root === null){
    //     return true;
    // }
    // if(root.left === null && root.right === null){
    //     if(pre !== null && pre.val >= root.val){
    //         return false;
    //     }
    //     else{
    //         pre = root;
    //         return true;
    //     }
        
    // }
    
    // left = isValidBST(root.left);
    // if(!left){
    //     return false;
    // }
    // if(pre !== null && pre.val >= root.val)
    //     return false;
    // pre = root;
    // right = isValidBST(root.right);
    // return right;
    
    var stack = [];
    var pre = null;
    var cur = root;

    while(cur !== null){
        stack.push(cur);
        cur = cur.left;
    }
    while(stack.length > 0){
        cur = stack.pop();
        if(pre !== null && pre.val >= cur.val)
            return false;
        pre = cur;
        cur = cur.right;
        while(cur !== null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    return true;
};