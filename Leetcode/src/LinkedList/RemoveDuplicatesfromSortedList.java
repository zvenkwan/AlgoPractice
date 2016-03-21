package LinkedList;
/**
 * 83. Remove Duplicates from Sorted List
 * @author zg55
 *Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

Show Tags

 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) {
            return head;
        }
        if(head.val==head.next.val) {
            head.next=head.next.next;
            return deleteDuplicates(head);
        } else {
            head.next=deleteDuplicates(head.next);
        }
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
