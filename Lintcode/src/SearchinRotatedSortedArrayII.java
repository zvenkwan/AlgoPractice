/**
 * 
 * @author jguan
 *63. Search in Rotated Sorted Array II 
 Description
 Notes
 Testcase
 Judge
Discuss 
Follow up for Search in Rotated Sorted Array:

What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.

Have you met this question in a real interview? 
Example
Given [1, 1, 0, 1, 1, 1] and target = 0, return true.
Given [1, 1, 1, 1, 1, 1] and target = 0, return false.
 */
public class SearchinRotatedSortedArrayII {
    /**
     * @param A: an integer ratated sorted array and duplicates are allowed
     * @param target: An integer
     * @return: a boolean 
     */
    public boolean search(int[] A, int target) {
        // can not use binary search, worst case O(n)
    	
    	for (int i = 0; i < A.length; i ++) {
            if (A[i] == target) {
                return true;
            }
        }
        return false;
    	
//        but if you do binary search, it can be below
        
//        if(A == null || A.length == 0) return false;
//        int st = 0;
//        int ed = A.length - 1;
//        return binarySearch(A, st, ed, target);
    }
    
    public boolean binarySearch(int[] A, int start, int end, int target) {
        if(start + 1 >= end) {
            if(A[start] == target) return true;
            if(A[end] == target) return true;
            return false;
        }
        int mid = start + ( end - start ) / 2;
        if(A[start] < A[mid]) {
            if(A[start] <= target && target <= A[mid]) {
                return binarySearch(A, start, mid, target);
            } else {
                return binarySearch(A, mid, end, target);
            }
        } else if(A[mid] < A[end]) {
            if(A[mid] <= target && target <= A[end]) {
                return binarySearch(A, mid, end, target);
            } else {
                return binarySearch(A, start, mid, target);
            }
        } else {
            return binarySearch(A, start, mid, target) || binarySearch(A, mid, end, target);
        }
    }
    
    public static void main(String[] args) {
    	int[] A = {9,5,6,7,8,9,9,9,9,9,9};
    	int target = 8;
    	SearchinRotatedSortedArrayII s = new SearchinRotatedSortedArrayII();
    	System.out.println(s.search(A, target));
    }
}
