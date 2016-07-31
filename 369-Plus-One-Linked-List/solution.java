/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode tail = helper;
        ListNode stop = helper; // stop is the first digit that carry stops after adding 1
        
        while(tail.next != null){
            tail = tail.next;
            if(tail.val != 9)
                stop = tail;
        }
        
        if(tail.val != 9){
            tail.val++;
        }
        else{
            stop.val++;
            while(stop.next != null){
                stop = stop.next;
                stop.val = 0;
            }
        }
        
        return helper.val == 0? helper.next:helper;
        
    }
}