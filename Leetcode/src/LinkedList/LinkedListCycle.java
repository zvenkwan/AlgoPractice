package LinkedList;
/**
 * leetcode 141. Linked List Cycle 
 * @author zg55
 *Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

Hide Company Tags Amazon Microsoft Bloomberg Yahoo
Hide Tags Linked List Two Pointers
Hide Similar Problems (M) Linked List Cycle II

 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) break;
        }
        if(fast == null || fast.next == null)
			return false;
        return true;
    }
}
