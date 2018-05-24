/**
 * 
 * @author jguan
 *143. Sort Colors II 
 Description
 Notes
 Testcase
 Judge
Discuss 
Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.

 Notice
You are not suppose to use the library's sort function for this problem.

k <= n

Have you met this question in a real interview? 
Example
Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].

Challenge 
A rather straight forward solution is a two-pass algorithm using counting sort. That will cost O(k) extra memory. Can you do it without using extra memory?
 */
public class SortColorsII {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if(colors == null || colors.length < 2) return;
        
        sortColors2(colors, 0, colors.length - 1, 1, k );
    }
    
    private void sortColors2(int[] colors, int start, int end, int from, int to) {
        if(from >= to) return;
        if(start >= end) return;
        int l = start;
        int r = end;
        int mid = from + (to - from) / 2;
        
        while(l <= r) {
            while(l <= r && colors[l] <= mid ) {
                l++;
            }
            
            while(l <= r && colors[r] > mid) {
                r--;
            }
            
            if(l <= r) {
                int t = colors[r];
                colors[r] = colors[l];
                colors[l] = t;
                l++;
                r--;
            }
        }
        
        sortColors2(colors, start, r, from, mid);
        sortColors2(colors, l, end, mid+1, to);
    }
}
