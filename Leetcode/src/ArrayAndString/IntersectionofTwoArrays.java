package ArrayAndString;
/**
 * leetcode 349. Intersection of Two Arrays  
Total Accepted: 27552
Total Submissions: 61980
Difficulty: Easy
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
Hide Tags Binary Search Hash Table Two Pointers Sort
Hide Similar Problems (E) Intersection of Two Arrays II

 */
import java.util.HashSet;

public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> map = new HashSet<Integer>();
        for(int i:nums1) map.add(i);
        HashSet<Integer> res = new HashSet<Integer>();
        for(int i:nums2) {
            if(map.contains(i)) {
                res.add(i);
            }
        }
        int s = res.size();
        int r[] = new int[s];
        for(int i: res)
            r[--s]=i;
        return r;
    }
}