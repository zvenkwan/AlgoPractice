import java.util.Arrays;
import java.util.PriorityQueue;
/**
 * 
 * @author jguan
 *
1615. The result of investment
Given a list funds representing the investor's investment each time. There are three companies A, B, C, and their initial funds are a, b, and c. Investors will invest in the company with the fewest funds each time (when multiple companies have the same funds, the investor will invest in the company with the smallest id). Output the final funds of A, B, C.

Example
Given funds=[1,2,1,3,1,1], a=1, b=2, c=1, return [4,5,4]

Explanation:
In the first round of investment, the funds of A and C are the same, and A is selected. At this time, a=2, b=2, c=1
In the second round of investment, C has the minimal funds, and invest in C, at this time a=2, b=2, c=3
In the third round of investment, the funds of A and B are the same, and A is selected. At this time, a=3, b=2, c=3
In the fourth round of investment, B has the minimal funds, and invest in B, at this time a=3, b=5, c=3
In the fifth round of investment, the funds of A and C are the same, and A is selected. At this time, a=4, b=5, c=3
In the sixth round of investment, C has the minimal funds, and invest in C, at this time a=4, b=5, c=4
Given funds=[2,1,1,1], a=1, b=2, c=2, return [4,3,3]

Explanation:
In the first round of investment, A has the minimal funds, and invest in A, at this time a=3, b=2, c=2
In the second round of investment, the funds of B and C are the same, and B is selected. At this time, a=3, b=3, c=2
In the third round of investment, C has the minimal funds, and invest in C, at this time a=3, b=3, c=3
In the fourth round of investment, the funds of A, B and C are the same, and A is selected. At this time, a=4, b=3, c=3
Notice
1<= The length of funds<= 500000
1<= funds[i],a,b<=100
 */
public class CharitableGiving {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {25,8,2,35,15,120,55,42};
		System.out.println(Arrays.toString(charitableGiving(input)));
	}
	
	public static String[] charitableGiving(int[] input) {
		String[] company = new String[] {"A", "B", "C"};
		PriorityQueue<Company> comp = new PriorityQueue<>();
		for(String name: company) {
			comp.offer(new Company(name));
		}
		String[] res = new String[input.length];
		int i = 0;
		for(int num: input) {
			Company c = comp.poll();
			res[i++] = c.name;
			c.bal += num;
			comp.offer(c);
		}
		return res;
	}
}

class Company implements Comparable<Company>{
	String name;
	int bal;
	public Company(String name) {
		this.name = name;
		this.bal = 0;
	}
	@Override
	public int compareTo(Company o2) {
		if(this.bal < o2.bal) {
			return -1;
		} else if(this.bal > o2.bal) {
			return 1;
		} else {
			return this.name.compareTo(o2.name);
		}
	}
}
//lintcode 1615. The result of investment
//public class Solution {
//    /**
//     * @param funds: The investment each time
//     * @param a: The initial funds of A
//     * @param b: The initial funds of B
//     * @param c: The initial funds of C
//     * @return: The final funds
//     */
//    public int[] getAns(int[] funds, int a, int b, int c) {
//        // Write your code here
//		PriorityQueue<Company> comp = new PriorityQueue<>();
//		comp.offer(new Company(0, a));
//		comp.offer(new Company(1, b));
//		comp.offer(new Company(2, c));
//		int[] res = new int[3];
//		int i = 0;
//		for(int num: funds) {
//			Company cp = comp.poll();
//			cp.bal += num;
//			comp.offer(cp);
//		}
//		while(!comp.isEmpty()) {
//		    Company cp = comp.poll();
//		    res[cp.id] = cp.bal;
//		}
//		return res;
//    }
//}
//
//class Company implements Comparable<Company>{
//	int id;
//	int bal;
//	public Company(int id, int bal) {
//		this.id = id;
//		this.bal = bal;
//	}
//	@Override
//	public int compareTo(Company o2) {
//		if(this.bal < o2.bal) {
//			return -1;
//		} else if(this.bal > o2.bal) {
//			return 1;
//		} else {
//			return this.id - o2.id;
//		}
//	}
//}