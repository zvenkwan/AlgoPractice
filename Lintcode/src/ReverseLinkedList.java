/**
 * 
 * @author jguan
 *
35. Reverse Linked List
Reverse a linked list.

Example
For linked list 1->2->3, the reversed linked list is 3->2->1

Challenge
Reverse it in-place and in one-pass
 */
public class ReverseLinkedList {

	/**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
	ListNode newHead = null;
    public ListNode reverse(ListNode head) {
        // write your code here
    	
//    	iteration
    	ListNode prev = null;
    	while(head != null) {
//    		use temp to store the next node in the original
//    		then reverse the curr, next point to prev
    		ListNode temp = head.next;
    		head.next = prev;
    		prev = head;
    		head = temp;
    	}
    	return prev;
    	
    	
//    	recursion
//        if(head == null) return head;
//        helper(head);
//        head.next = null;
//        return newHead;
    }
//    recursion
    public ListNode helper(ListNode head) {
        if(head.next == null) {
        	newHead = head;
        	return head;
        }
        ListNode last = helper(head.next);
        last.next = head;
        
        return head;
        
    }
    
    public static void main(String[] args) {
    	int[] arr = {1,2,3,5};
    	ListNode head = ListNode.buildListNode(arr);
    	ReverseLinkedList rll = new ReverseLinkedList();
    	System.out.println(rll.reverse(head));
    }
}
