/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode helper = new ListNode(0);
        ListNode cur = helper;
        
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            cur.next = new ListNode(sum%10);
            carry = sum/10;
            
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            int sum = l1.val + carry;
            cur.next = new ListNode(sum%10);
            carry = sum/10;
            cur = cur.next;
            l1 = l1.next;
        }
        
        while(l2 != null){
            int sum = l2.val + carry;
            cur.next = new ListNode(sum%10);
            carry = sum/10;
            cur = cur.next;
            l2 = l2.next;
        }
        
        if(carry != 0) cur.next = new ListNode(carry);
        
        return helper.next;
    }
}