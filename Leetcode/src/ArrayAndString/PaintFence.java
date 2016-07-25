package ArrayAndString;
/**
 * leetcode 276. Paint Fence
 * @author zg55
 *There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.

Hide Company Tags Google
Hide Tags Dynamic Programming
Hide Similar Problems (E) House Robber (M) House Robber II (M) Paint House (H) Paint House II
Have you met this question in a real interview? Yes  
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if(k <= 0 || n <= 0) return 0;
        if(n == 1) return k;
        int diff = k*(k-1);
        int same = k;
        for(int i = 2; i<n; i++) {
            int t = diff;
            diff = (diff+same) * (k-1);
            same = t;
        }
        return diff+same;
    }
}
