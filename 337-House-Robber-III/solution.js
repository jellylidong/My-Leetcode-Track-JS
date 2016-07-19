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
var rob = function(root) {
    
    //in JS, a pointer can not be used as the key of dictionary
    // if(root === null)   return 0;
    // var map = {};
    // var helper = function(cur, able2robCur){
    //     if(cur === null)
    //         return 0;
    //     if(map[cur.Value] === undefined) map[cur] = {};
    //     if(able2robCur === true){
    //         if(map[cur][true] !== undefined)
    //             return map[cur][true];
    //         let res = cur.val + helper(cur.left, false) + helper(cur.right, false);
    //         map[cur][true] = res;
    //         // console.log(map[cur]);
    //         return res;
    //     }
    //     else{
    //         if(map[cur][false] !== undefined)
    //             return map[cur][false];
    //         let res = Math.max(helper(cur.left, true), helper(cur.left, false)) + 
    //                   Math.max(helper(cur.right, true), helper(cur.right, false));
    //         map[cur][false] = res;
    //         return res;
    //     }
    // }
    // // console.log(map[root]);
    // let res = Math.max(helper(root, true), helper(root, false));
    // console.log(map[root]);
    // console.log(map[root.left]);
    // console.log(map[root.right]);
    // return res;
    
    var helper = function(root){
        if(root === null)   return [0, 0];
        var left = helper(root.left);
        var right = helper(root.right);
        
        var robCur = root.val + left[1] + right[1];
        var noRobCur = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return [robCur, noRobCur];
    }
    
    var res = helper(root);
    return Math.max(res[0], res[1]);
};