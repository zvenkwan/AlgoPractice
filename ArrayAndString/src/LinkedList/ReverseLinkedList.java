package LinkedList;
/**
 * 206. Reverse Linked List
 * Reverse a singly linked list.
 * @author guanziwen
 *
 */
public class ReverseLinkedList {
	
	public ListNode reverseList(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode ln = reverseList(head.next);
		head.next.next=head;
		head.next=null;
		return ln;
    }
	
	private void printList(ListNode head) {
		while(head!=null) {
			System.out.print(head.val);
			if(head.next==null) {
				System.out.println();
			} else {
				System.out.print("->");
			}
			head=head.next;
		}
	}
	
	public static void main(String[] args) {
		ReverseLinkedList r = new ReverseLinkedList();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(0);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		r.printList(n1);
		System.out.println();
		r.printList(r.reverseList(n1));
	}

}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}