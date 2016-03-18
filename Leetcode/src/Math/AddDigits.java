package Math;
/**
 * 258. Add Digits
 * @author zg55
 *Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?

Hint:

A naive implementation of the above process is trivial. Could you come up with other methods?
What are all the possible results?
How do they occur, periodically or randomly?
You may find this Wikipedia article useful.
https://en.wikipedia.org/wiki/Digital_root
 */
public class AddDigits {
	public int addDigits(int num) {
//		by looking at a few numbers,
//		will see that 
//		0 add digits to 0
//		1 add digits to 1
//		2->2
//		3->3
//		4->4
//		5->5
//		6->6
//		7->7
//		8->8
//		9->9
//		10->1
//		11->2
//		...
//		18->9
//		19->1
		return (num-1)%9+1;
    }
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	}

}
