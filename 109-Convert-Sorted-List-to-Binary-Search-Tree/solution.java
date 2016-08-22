/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        node = head;
        while(node != null){
            len++;
            node = node.next;
        }
        
        node = head;
        
        return helper(1, len);
    }
    
    public TreeNode helper(int lo, int hi){
        if(lo > hi) return null;
        int mid = lo + (hi-lo)/2;
        TreeNode left = helper(lo, mid-1);
        TreeNode root = new TreeNode(node.val);
        node = node.next;
        TreeNode right = helper(mid+1, hi);
        root.left = left;
        root.right = right;
        return root;
    }
}