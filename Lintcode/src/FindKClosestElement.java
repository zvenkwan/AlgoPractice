/**
 * 
 * @author jguan
 *460. Find K Closest Elements 
 Description
 Notes
 Testcase
 Judge
Discuss 
Given a target number, a non-negative integer target and an integer array A sorted in ascending order, find the k closest numbers to target in A, sorted in ascending order by the difference between the number and target. Otherwise, sorted in ascending order by number if the difference is same.

Have you met this question in a real interview? 
Example
Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].

Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].

Challenge 
O(logn + k) time complexity.
 */
public class FindKClosestElement {
//	logn to find starting position and then scan at most k element
//	total time O(logn + k)
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        if(A == null || A.length < k) return A;
        int s = 0;
        int e = A.length - 1;
        while( s + 1 < e) {
            int m = s + (e-s)/2;
            if(A[m] <= target) {
                s = m;
            } else {
                e = m;
            }
        }
        int[] res = new int[k];
        int i = 0;
        while(i < k) {
            if(s >= 0 && e < A.length) {
                if(target - A[s] <= A[e] - target) {
                    if(s == e) e++;
                    res[i++] = A[s--];
                } else {
                    if(s == e) s--;
                    res[i++] = A[e++];
                }
            } else if(s >= 0){
                res[i++] = A[s--];
            } else {
                res[i++] = A[e++];
            }
        }
        return res;
    }
}
