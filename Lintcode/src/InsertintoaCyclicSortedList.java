
public class InsertintoaCyclicSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n1;
		
		InsertintoaCyclicSortedList a = new InsertintoaCyclicSortedList();
		a.insert(n1, 1);
		
	}
    public ListNode insert(ListNode node, int x) {
        // Write your code here
        if(node == null ) {
            node = new ListNode(x);
            node.next = node;
            return node;
        }
        
        ListNode p = node.next;
        ListNode prev = node;
        ListNode xnode = new ListNode(x);
        while(p != node) { 
            if( x <= p.val && x >= prev.val) 
                break;
            if( x > prev.val && x < p.val)
                break;
            prev = p;
            p = p.next;
        }
        prev.next = xnode;
        xnode.next = p;
        return xnode;
    }
}
