/**
 * 
 * @author jguan
 *165. Merge Two Sorted Lists
Merge two sorted (ascending) linked lists and return it as a new sorted list. The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.

Example
Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.
 */
public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = ListNode.buildListNode(new int[]{1,3,8,11,15});
		ListNode l2 = ListNode.buildListNode(new int[]{2});
		System.out.println(l1);
		System.out.println(l2);
		MergeTwoSortedLists m = new MergeTwoSortedLists();
		ListNode l3 = m.mergeTwoLists(l1, l2);
		System.out.println(l3);
	}
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // recursion, O(n) time and O(n) space
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        // if(l1.val < l2.val) {
        //     l1.next = mergeTwoLists(l1.next, l2);
        //     return l1;
        // } else {
        //     l2.next = mergeTwoLists(l1, l2.next);
        //     return l2;
        // }
        
        // iteration
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if(l1 != null) {
            prev.next = l1;
        } else {
            prev.next = l2;
        }
        return dummy.next;
    }
}
