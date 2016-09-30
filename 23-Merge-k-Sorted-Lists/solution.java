/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if(len == 0)    return null;
		while(len > 1){
			for(int i = 0; i < len/2; i++){
				lists[i] = merge(lists[i], lists[len-1-i]);
			}
			if(len%2 == 1)	len++;
			len = len/2;
		}
		return lists[0];
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
		if(l1 == l2)	return l1;
		ListNode helper = new ListNode(0);
		ListNode cur = helper;
		while(l1 != null && l2 != null){
			if(l1.val > l2.val){
				cur.next = l2;
				l2 = l2.next;
			}
			else{
				cur.next = l1;
				l1 = l1.next;
			}
			cur = cur.next;
		}
		if(l1 != null)	cur.next = l1;
		if(l2 != null)	cur.next = l2;
		return helper.next;
	}
}