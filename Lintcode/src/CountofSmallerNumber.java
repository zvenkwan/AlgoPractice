import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author jguan
 *Back
248. Count of Smaller Number
Description
Give you an integer array (index from 0 to n-1, where n is the size of this array, value from 0 to 10000) and an query list. For each query, give you an integer, return the number of element in the array that are smaller than the given integer.

We suggest you finish problem Segment Tree Build and Segment Tree Query II first.

Have you met this question in a real interview?  
Example
For array [1,2,7,8,5], and queries [1,8,5], return [0,4,2]

Challenge
Could you use three ways to do it.

Just loop
Sort and binary search
Build Segment Tree and Search.
 */
public class CountofSmallerNumber {
	/**
     * @param A: An integer array
     * @param queries: The query list
     * @return: The number of element in the array that are smaller that the given integer
     */
    public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        ArrayList<Integer> list  = new ArrayList<>();
        if(A==null || queries==null || queries.length==0)
            return list;
        Arrays.sort(A);
        for(int i = 0 ; i < queries.length;i++) {
            int res = binarySearch(A, queries[i]);
            int count = res + 1;
            list.add(count);
        }
        return list;
    }
    
    private int binarySearch(int[] A, int target) {
        if(A.length == 0) return -1;
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(A[start] >= target) return start-1;
        else if(A[end] < target) return end;
        else return start;

    }
}
