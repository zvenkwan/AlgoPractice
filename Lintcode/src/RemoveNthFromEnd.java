/**
 * 
 * @author jguan
 *174. Remove Nth Node From End of List
Given a linked list, remove the nth node from the end of list and return its head.

Example
Given linked list: 1->2->3->4->5->null, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5->null.

Challenge
Can you do it without getting the length of the linked list?

Notice
The minimum number of nodes in list is n.
 */
public class RemoveNthFromEnd {

    /**
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        ListNode p = dummy;
        int k = 0;
        while(current != null) {
            
            current = current.next;
            if(k > n) p = p.next;
            k++;
        }
        ListNode target = p.next;
        p.next = target.next;
        target.next = null;
        return dummy.next;
    }

}
