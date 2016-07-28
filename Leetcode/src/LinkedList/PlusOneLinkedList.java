package LinkedList;
/**
 * leetcode 369. Plus One Linked List
 * @author zg55
 * Given a non-negative number represented as a singly linked list of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Example:
Input:
1->2->3

Output:
1->2->4
Hide Company Tags Google
Hide Tags Linked List
Hide Similar Problems (E) Plus One
Have you met this question in a real interview? Yes  No
Discuss 
 */
public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        if(head == null) return head;
        int c = plus(head, 1);
        if(c==0) return head;
        ListNode l = new ListNode(1);
        l.next = head;
        return l;
    }
    
    private int plus(ListNode node, int n) {
        int carry = 0;
        if(node.next!=null) {
            carry = plus(node.next, n);
        } else {
            node.val = node.val+n;
        }
        node.val+=carry;
        carry = node.val>9?1:0;
        node.val%=10;
        return carry;
    }
}
