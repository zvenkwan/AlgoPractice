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
        // write your code here
//        if(l1 == null) return l2;
//        if(l2 == null) return l1;
//        ListNode prev = new ListNode(Integer.MIN_VALUE);
//        ListNode dummy = prev;
//        prev.next = l1;
//        while(l1 != null && l2 != null) {
//            if(prev.val <= l2.val && l2.val < l1.val) {
//                prev.next = l2;
//                ListNode temp2 = l2.next;
//                l2.next = l1;
//                l2 = temp2;
//            }
//            prev = l1;
//            l1 = l1.next;
//        }
//        if(l1 == null)
//            prev.next = l2;
//        return dummy.next;
    	
    	if(l1 == null && l2 == null) return null;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while(p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                prev.next = p1;
                p1 = p1.next;
            } else {
                prev.next = p2;
                p2 = p2.next;
            }
            prev = prev.next;
        }
        while(p1 != null) {
            prev.next = p1;
            p1 = p1.next;
            prev = prev.next;
        }
        while(p2 != null) {
            prev.next = p2;
            p2 = p2.next;
            prev = prev.next;
        }
        return dummy.next;
    }
}
