package LinkedList;
/**
 * 160. Intersection of Two Linked Lists
 * @author zg55
 *Write a program to find the node at which the intersection of two singly linked lists begins.
 *For example, the following two linked lists:
 *A:		a1 ¡ú a2
                   	¨K
                     c1 ¡ú c2 ¡ú c3
                   	¨J            
B:     	b1 ¡ú b2 ¡ú b3
begin to intersect at node c1.
Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionOfTwoLinkedLists {
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        brute force
//        traverse A then look for item in B, this takes O(mn) time and O(1) space
		
//		hash table takes O(m+n) time and O(m) or O(n) space
		
//		two pointer
//		use two pointer pA and pB point to head of A and B respectively
//		traverse the nodes one by one
//		when the pointer comes to the end of list, move it to the head of the other list
//		if there is an intersection, the two pointers will meet at no longer than time that all pointers have traverse both lists
		ListNode pA = headA;
		ListNode pB = headB;
		boolean isAdone = false;
		boolean isBdone = false;
		while ( pA!=null && pB!=null) {
			if(pA==pB)
				return pA;
			else {
				if(pA.next==null&&!isAdone) {
					pA=headB;
					isAdone = true;
				}
				else
					pA=pA.next;
				if(pB.next==null&&!isBdone) {
					pB=headA;
					isBdone = true;
				}
				else
					pB=pB.next;
			}
		}
		return null;
    }
	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode b1 = new ListNode(3);
		ListNode b2 = new ListNode(4);
		ListNode b3 = new ListNode(5);
		ListNode c1 = new ListNode(6);
		ListNode c2 = new ListNode(7);
		ListNode c3 = new ListNode(8);
		a1.next=a2;
		a2.next=c1;
		c1.next=c2;
		c2.next=c3;
		b1.next=b2;
		b2.next=b3;
		b3.next=c1;
		ListNode.printList(a1);
		ListNode.printList(b1);
		System.out.println(new IntersectionOfTwoLinkedLists().getIntersectionNode(a1,b1).val);
	}

}
