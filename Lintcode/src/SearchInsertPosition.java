/**
 * 
 * @author jguan
 *60. Search Insert Position 
 Description
 Notes
 Testcase
 Judge
Discuss 
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume NO duplicates in the array.

Have you met this question in a real interview? 
Example
[1,3,5,6], 5 → 2

[1,3,5,6], 2 → 1

[1,3,5,6], 7 → 4

[1,3,5,6], 0 → 0

Challenge 
O(log(n)) time
 */
public class SearchInsertPosition {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0) return 0;
        int start = 0 ;
        int end =A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start ) /2;
            if(target <= A[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(A[start] >= target) return start;
        if(A[end] >= target) return end;
        return end + 1;
    }


}
