/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode head;
    Random randGen;
    public Solution(ListNode head) {
        this.head = head;
        this.randGen = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode res = null;
        ListNode cur = head;
        
        for(int i = 1; cur != null; i++){
            if(randGen.nextInt(i) == 0){
                res = cur;
            }
            cur = cur.next;
        }
        
        return res.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */