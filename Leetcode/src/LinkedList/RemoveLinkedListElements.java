package LinkedList;
/**
 * 203. Remove Linked List Elements
 * @author zg55
 *Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return head;
        if(head.val==val)
            return removeElements(head.next,val);
        head.next=removeElements(head.next,val);
        return head;
    }
}
