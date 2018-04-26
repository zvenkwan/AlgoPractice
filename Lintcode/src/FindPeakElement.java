/**
 * 
 * @author jguan
 *75. Find Peak Element 
 Description
 Notes
 Testcase
 Judge
Discuss 
There is an integer array which has the following features:

The numbers in adjacent positions are different.
A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
We define a position P is a peak if:

A[P] > A[P-1] && A[P] > A[P+1]
Find a peak element in this array. Return the index of the peak.

 Notice
It's guaranteed the array has at least one peak.
The array may contain multiple peeks, find any of them.
The array has at least 3 numbers in it.
Have you met this question in a real interview? 
Example
Given [1, 2, 1, 3, 4, 5, 7, 6]

Return index 1 (which is number 2) or 6 (which is number 7)
 */
public class FindPeakElement {
    /*
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        // the arry has at least 3 nums
        int s = 0;
        int e = A.length - 1;
        while (s + 1 < e) {
            int m = s + (e-s)/2;
            if(A[m] > A[m - 1] && A[m] > A[m+1]) {
                return m;
            } else if(A[m] > A[m - 1]) {
                s = m;
            } else {
                e = m;
            }
        }
        return A[s]>A[e]?s:e;
    }
}
