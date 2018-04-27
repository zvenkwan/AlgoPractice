/**
 * 
 * @author jguan
 *62. Search in Rotated Sorted Array 
 Description
 Notes
 Testcase
 Judge
Discuss 
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Have you met this question in a real interview? 
Example
For [4, 5, 1, 2, 3] and target=1, return 2.

For [4, 5, 1, 2, 3] and target=0, return -1.

Challenge 
O(logN) time
 */
public class SearchinRotatedSortedArray {

    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        
        // binary search may cut it into 2 sorted arrays
        
        if(A == null || A.length == 0) return -1;
        int s = 0;
        int e = A.length - 1;
        while(s + 1 < e) {
            int m = s + (e-s)/2;
            if(A[s] < A[m]) {
                if(A[s] <= target && target <= A[m]) {
                    e = m;
                } else {
                    s = m;
                }
            }
            else {
                if(A[m] <= target && target <= A[e]) {
                    s = m;
                } else {
                    e = m;
                }
            }
        }            
        if(A[s] == target) return s;
        if(A[e] == target) return e;
        return -1;
    }
}
