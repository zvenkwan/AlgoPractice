package LinkedList;
/**
 * leetcode 234. Palindrome Linked List
 * Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

Hide Company Tags Amazon Facebook
Hide Tags Linked List Two Pointers
Hide Similar Problems (E) Palindrome Number (E) Valid Palindrome (E) Reverse Linked List

 */
import java.util.Stack;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> first = new Stack<Integer>();
        while(fast!=null && fast.next!=null) {
            first.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
            //can reverse the first half and then compare instead of using a stack
        }
        if(fast != null) slow = slow.next;
        while(slow!=null) {
            if(slow.val!=first.pop().intValue()) return false;
            slow = slow.next;
        }
        return true;
        
// 		return isPalindromeRecurse(head, getLength(head)).result;
    }
    
// 	private Result isPalindromeRecurse(ListNode head, int length) {
// 		if(head == null || length == 0)
// 			return new Result(head, true);
// 		if(length == 1)
// 			return new Result(head.next, true);
// 		Result res = isPalindromeRecurse(head.next, length - 2);
// //		if false then return or the pointer comes to an end
// 		if(!res.result || res.node == null)
// 			return res;
// //		if true then see if the current value is same with the match position
// 		res.result = (head.val == res.node.val);
// //		set node to next node
// 		res.node = res.node.next;
// 		return res;
// 	}
	
// 	private int getLength(ListNode head) {
// 		int size = 0;
// 		while(head!=null) {
// 			size++;
// 			head = head.next;
// 		}
// 		return size;
// 	}
}


// class Result {
// 	ListNode node;
// 	boolean result;
// 	public Result(ListNode n, boolean result) {
// 		this.node = n;
// 		this.result = result;
// 	}
// }