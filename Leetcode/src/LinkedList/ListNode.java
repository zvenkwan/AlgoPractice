package LinkedList;

public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x;
	next = null;}
	public static void printList(ListNode head) {
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
}
