
public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
	
	public static ListNode buildListNode(int[] arr) {
		if(arr == null || arr.length == 0) return null;
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		for(int a: arr) {
			ListNode node = new ListNode(a);
			p.next = node;
			p = node;
		}
		return dummy.next;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListNode l = this;
		while(l != null) {
			sb.append(l.val);
			sb.append("->");
			l = l.next;
		}
		sb.append("null");
		return sb.toString();
	}
}
