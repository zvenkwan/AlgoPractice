package LinkedList;
/**
 * 21. Merge Two Sorted Lists
 * @author zg55
 *Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
        return l2;
        if(l2==null)
        return l1;
        if(l1==null&l2==null)
        return null;
        if(l1.val<=l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            ListNode temp = l2.next;
            l2.next=mergeTwoLists(l1, temp);
            return l2;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1=ListNode.buildList(new int[]{1,3});
		ListNode l2=ListNode.buildList(new int[]{0,2,4});
		ListNode l = new MergeTwoSortedLists().mergeTwoLists(l1,l2);
		ListNode.printList(l);
	}
}
