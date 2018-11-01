/**
 * 
 * @author jguan
 *103. Linked List Cycle II
Given a linked list, return the node where the cycle begins.

If there is no cycle, return null.

Example
Given -21->10->4->5, tail connects to node index 1，return 10
Explanation：
The last node 5 points to the node whose index is 1, which is 10, so the entrance of the ring is 10

Challenge
Follow up:

Can you solve it without using extra space?
 */
public class LinkedListCycleII {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        // x->x->...->x->x->CYCLE START POINT->x->x->x->x->x->...->BACK TO START
        // A denote that the distance from head to CYCLE START POINT
        // B denote that the distance from CYCLE START POINT to meeting POINT
        // N denote that the distance of CYCLE
        // x denote the constant number of cycles slow pointer runs before meeting fast
        // y denote the constant number of cycles fast pointer runs before meeting slow
        // slow runs 1 node/step, fast runs 2 node/step
        // (A + xN + B)/1 = (A + yN + B)/2
        // 2A + 2xN + 2B = A + yN + B
        // A + (2x - y)N + B = 0
        // (y - 2x)N = A + B
        // let c = y-2x, a constant
        // cN - B = A
        // (c-1)N + (N - B) = A
        // N - B is the distance from meeting point to CYCLE START POINT
        // (C-1)N contributes no node changes
        // so the distance of meeting point to the CYCLE START POINT is equals to A
        // have another pointer start from head, with the slow pointer keeps running from meeting pointer, they will meet at the START POINT
        
        if(head == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            // found cycle
            if(slow == fast) {
                ListNode slowhead = head;
                
                while(slow != slowhead) {
                    slow = slow.next;
                    slowhead = slowhead.next;
                }
                return slow;
            }
        } 
        return null;
    }


}
