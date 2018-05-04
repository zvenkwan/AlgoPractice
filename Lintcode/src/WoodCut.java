/**
 * 
 * @author jguan
 *183. Wood Cut
Description
Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.

You couldn't cut wood into float length.

If you couldn't get >= k pieces, return 0.

Have you met this question in a real interview?  
Example
For L=[232, 124, 456], k=7, return 114.

Challenge
O(n log Len), where Len is the longest length of the wood.
 */
public class WoodCut {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if(L == null || L.length == 0) return 0;
        int start = 0;
        int end = Integer.MIN_VALUE;
        for(int l:L) {
            end = Math.max(end, l);
        }
        
        // System.out.println(start);
        // System.out.println(end);
        
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(count(L, mid) >= k) start = mid;
            else end = mid;
        }
        if(count(L, end) ==k) return end;
        else return start;
    }
    
    public int count(int[] L, int length) {
        int count = 0;
        for(int l: L) {
                count += l/length;
        }
        return count;    
    }
}
