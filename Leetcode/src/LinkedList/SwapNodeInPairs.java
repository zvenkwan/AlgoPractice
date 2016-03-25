package LinkedList;
/**
 * leetcode 24. Swap Nodes in Pairs
 * @author zg55
 *Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodeInPairs {

	public ListNode swapPairs(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode newHead = head.next;
		head.next=swapPairs(newHead.next);
		newHead.next = head;
		return newHead;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
