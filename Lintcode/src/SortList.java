
public class SortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = ListNode.buildListNode(new int[]{2,-1,0});
		System.out.println(l1);
		SortList m = new SortList();
		ListNode l3 = m.sortList(l1);
		System.out.println(l3);
	}
    public ListNode sortList(ListNode head) {  
        // write your code here
        
        if(head == null || head.next == null) return head;
        ListNode midNode = findMid(head);
        ListNode second = midNode.next;
        midNode.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(second);
        return merge(left, right);
    }
    
    private ListNode merge(ListNode left, ListNode right) {
//    	System.out.println(left.val + ","+ right);
        if(left == null) return right;
        if(right == null) return left;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode prev = dummy;
        dummy.next = left;
        while(left != null && right != null) {
            if(prev.val <= right.val && right.val < left.val) {
                prev.next = right;
                prev = right;
                ListNode temp = right.next;
                right.next = left;
                right = temp;
            } else {
                prev = left;
                left = left.next;
            }
        }
        if(left == null) prev.next = right;
        return dummy.next;
    }
    
    private ListNode findMid(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
