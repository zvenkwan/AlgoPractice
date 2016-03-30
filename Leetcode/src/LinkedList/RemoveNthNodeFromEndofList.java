package LinkedList;
/**
 * 19. Remove Nth Node From End of List
 * @author zg55
 *Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 */
public class RemoveNthNodeFromEndofList {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
//    	use a fast pointer runs n steps ahead of a slow pointer
    	ListNode beforeHead = new ListNode(-1);
    	beforeHead.next = head;
    	ListNode l1 = beforeHead;
    	ListNode l2 = beforeHead;
    	while(l1.next!=null) {
    		l1=l1.next;
    		if(n--<=0) l2=l2.next;
    	}
    	l2.next= l2.next.next;
    	return beforeHead.next;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
