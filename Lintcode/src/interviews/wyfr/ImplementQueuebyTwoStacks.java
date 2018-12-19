package interviews.wyfr;

import java.util.LinkedList;
/**
 * 
 * @author jguan
 *40. Implement Queue by Two Stacks
As the title described, you should only use two stacks to implement a queue's actions.

The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.

Both pop and top methods should return the value of first element.

Example
push(1)
pop()     // return 1
push(2)
push(3)
top()     // return 2
pop()     // return 2
Challenge
implement it by two stacks, do not use any other data structure and push, pop and top should be O(1) by AVERAGE.
 */
public class ImplementQueuebyTwoStacks {
    LinkedList<Integer> in = null;
    LinkedList<Integer> out = null;
    public ImplementQueuebyTwoStacks() {
        // do intialization if necessary
        in = new LinkedList<Integer>();
        out = new LinkedList<Integer>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        in.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if(out.isEmpty()) {
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if(out.isEmpty()) {
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }


}
