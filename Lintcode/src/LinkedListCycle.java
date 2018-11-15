/**
 * 
 * @author jguan
 *102. Linked List Cycle
Given a linked list, determine if it has a cycle in it.



Example
Given -21->10->4->5, tail connects to node index 1, return true

Challenge
Follow up:
Can you solve it without using extra space?
 */
public class LinkedListCycle {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        if(fast == null) return false;
        while(fast != null && slow != fast) {
            slow = slow.next;
            if(fast.next == null) return false;
            fast = fast.next.next;
        }
        return fast != null;
        
        

        // write your code here
//        if(head == null) return false;
//        
//        ListNode slow = head;
//        ListNode fast = head;
//        
//        do {
//            slow = slow.next;
//            if(fast.next != null) {
//                fast = fast.next.next;
//            }
//            if(slow == fast) return true;
//        } while(fast != null && fast.next != null);
//        
//        return fast == slow;
        
    
    }
}
