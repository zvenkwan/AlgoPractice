package LinkedList;
/**
 * 328. Odd Even Linked List
 * @author zg55
 *Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)
        return head;
        ListNode first = head.next;
        ListNode second = head.next;
        ListNode even = second;
        while (head.next!=null&&head.next.next!=null) {
            head.next = even.next;
            head = head.next;
            even.next = head.next;
            even = head.next;
        }
        head.next=second;
        return first;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = ListNode.buildList(new int[]{1,2,3,4,5,6,7,8});
		ListNode.printList(head);
		new OddEvenLinkedList().oddEvenList(head);
		ListNode.printList(head);
		
	}

}
