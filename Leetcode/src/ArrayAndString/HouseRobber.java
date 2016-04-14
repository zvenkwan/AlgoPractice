package ArrayAndString;
/**
 * 198. House Robber
 * @author zg55
 *You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.

Hide Company Tags LinkedIn Airbnb
Hide Tags Dynamic Programming
Hide Similar Problems (M) Maximum Product Subarray (M) House Robber II (M) Paint House (E) Paint Fence (M) House Robber III

 */
public class HouseRobber {

	public int rob(int[] nums) {
		int notRob=0;
		int rob=0;
		for(int i: nums) {
			int t = notRob;
			notRob = Math.max(notRob, rob);
			rob = t+i;
		}
		return Math.max(notRob, rob);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
