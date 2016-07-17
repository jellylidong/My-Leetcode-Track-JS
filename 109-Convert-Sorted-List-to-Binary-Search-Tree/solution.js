/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {TreeNode}
 */
var sortedListToBST = function(head) {
    //method 1
    //if we don't store the list node into an array first,
    //for each tree level, to find a the root node of current level
    //we need to spend n/2 time
    //for a balanced tree with N nodes, its height is logN
    //so in this method the time complexity is NlogN and no extra space
    
    //method 2
    //we can store the nodes into an array first,
    //then we can get any node in O(1) time,
    //so the time complexity is O(n) and space complexity is O(n)
    
    var nodes = [];
    while(head !== null){
        nodes.push(head);
        head = head.next;
    }
    
    var helper = function(nodes, lo, hi){
        if(lo > hi) return null;
        if(lo === hi)    return new TreeNode(nodes[lo].val);
        var mid = lo + Math.floor((hi-lo)/2);
        var curRoot = new TreeNode(nodes[mid].val);
        curRoot.left = helper(nodes, lo, mid-1);
        curRoot.right = helper(nodes, mid+1, hi);
        return curRoot;
    };
    
    return helper(nodes, 0, nodes.length-1);
};