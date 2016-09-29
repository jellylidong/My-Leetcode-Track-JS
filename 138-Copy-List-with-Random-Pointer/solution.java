/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)	return null;
		RandomListNode cur = head;
		while(cur != null){
			RandomListNode node = new RandomListNode(cur.label);
			node.next = cur.next;
			cur.next = node;
			cur = cur.next.next;
		}
		
		cur = head;
		while(cur != null){
			RandomListNode next = cur.next;
			if(cur.random != null)
			    next.random = cur.random.next;
			cur = next.next;
		}
		
		cur = head;
		RandomListNode newHead = cur.next;
		RandomListNode newCur = newHead;
		while(cur != null){
			newCur = cur.next;
			cur.next = newCur.next;
			if(newCur.next != null)
			    newCur.next = newCur.next.next;
			cur = cur.next;
		}
		
		return newHead;
    }
}