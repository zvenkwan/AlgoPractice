/**
 * 
 * @author jguan
 *
380. Intersection of Two Linked Lists
Write a program to find the node at which the intersection of two singly linked lists begins.

Example
The following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.

Challenge
Your code should preferably run in O(n) time and use only O(1) memory.

Notice
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
 */
public class IntersectionofTwoLinkedLists {
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here
        ListNode pa = headA;
        ListNode pb = headB;
//        when pa == pb, they either meet at the intersection, or both come to the end
        while(pa != pb) {
//        	when pa comes to the end of list, let it start from beginning of listB
            if(pa == null && pb != null) {
                pa = headB;
                pb = pb.next;
                continue;
            }
//        	when pb comes to the end of list, let it start from beginning of listA
            if(pb == null && pa != null) {
                pb = headA;
                pa = pa.next;
                continue;
            }
            pa = pa.next;
            pb = pb.next;
        }
        
        return pa == null? null : pa;
    }


}
