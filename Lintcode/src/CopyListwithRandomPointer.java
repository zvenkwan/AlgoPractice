import java.util.HashMap;
import java.util.Map;
/**
 * 
105. Copy List with Random Pointer
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

Challenge
Could you solve it with O(1) space?
 */
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListwithRandomPointer {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        
        if(head == null) return null;
        
        Map<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
        
        RandomListNode curr = head;
        while(curr != null) {
            RandomListNode copy = new RandomListNode(curr.label);
            map.put(curr.label, copy);
            curr = curr.next;
        }
        
        curr = head;
        while(curr != null) {
            RandomListNode next = curr.next;
            RandomListNode random = curr.random;
            if(next != null) {
                map.get(curr.label).next = map.get(next.label);
            }
            if(random != null) {
                map.get(curr.label).random = map.get(random.label);
            }
            curr = curr.next;
        }
        
        return map.get(head.label);
    }


}
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};