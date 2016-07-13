package ArrayAndString;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * leetcode 350. Intersection of Two Arrays II  QuestionEditorial Solution  My Submissions
Total Accepted: 19401
Total Submissions: 46620
Difficulty: Easy
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
Hide Tags Binary Search Hash Table Two Pointers Sort
Hide Similar Problems (E) Intersection of Two Arrays

 * @author zg55
 *
 */
public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i: nums1) map.put(i, map.getOrDefault(i,0)+1);
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i: nums2) {
            int n = map.getOrDefault(i, 0);
            if(n>0) {
                res.add(i);
                map.put(i, --n);
            }
        }
        int r[] = new int[res.size()];
        for(int i=0;i<res.size();i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}
