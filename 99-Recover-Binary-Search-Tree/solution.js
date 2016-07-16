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
var recoverTree = function(root) {
    //variant of inorder traversal
    var n1 = null;
    var n2 = null;
    var cur = root;
    var pre = null;
    var traverse = function(root){
        if(root === null)
            return;
        traverse(root.left);
        //for the two swapped node, one must be smaller than it's root, and the other is bigger than its root
        //since we are doing inorder traversal, the first one we can find must be the bigger-than-pre one
        //so let n1 = pre, 
        //the 2nd node we can find must be the smaller-than-pre one
        //let n2 = root
        if(n1 === null && pre !== null && pre.val >= root.val)
            n1 = pre;
        if(n1 !== null && pre.val >= root.val)
            n2 = root; //!!!!!!!!! root, not pre
            
        pre = root;
        traverse(root.right);
    }
    traverse(cur);
    // console.log(n1.val + " " + n2.val);
    tmp = n1.val;
    n1.val = n2.val;
    n2.val = tmp;
    // console.log(n1.val + " " + n2.val);
};