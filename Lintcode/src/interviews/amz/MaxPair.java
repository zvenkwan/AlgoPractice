package interviews.amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/**
 * 
 * @author jguan
 *1635. Max Pair
Give two Lists, give a maximum value, find a bunch in each of the two lists, and find all the pairs that are closest to the maximum but not larger than the maximum.

Example
Give a=[2,3,4,5,6], b=[4,5,7], x=8', return [[3,5],[4,4]].

Explanation:
the sum of [3,5] or [4,4] is 8, which is no larger than 8. 
Give a=[2,3,4,5,6], b=[4,5,7], x=10', return [[3,7],[5,5],[6,4]].

Explanation:
the sum of [3,7],[5,5],[6,4] is 10, which is no larger than 10. 
Notice
The length of the two lists do not exceed 100000100000.
Each element do not exceed 10000000001000000000.
 */
public class MaxPair {

    /**
     * @param a: the first list
     * @param b: the second list
     * @param x: the max sum
     * @return: the pairs whose sum are not exceed x
     */
    public int[][] getAns(int[] a, int[] b, int x) {
        // Write your code here.
        // sort both array
        // iterate the smaller array
        // find the peer which makes the sum not larger than x using binary search
        // use an Hashmap to store sum, pairs
        // use max to store best sum
        // find pairs by max, and return
        
        // pay attention to duplicate values and pairs
        
        if(a == null || b == null || a.length < 1 || b.length < 1) return new int[0][0];
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        int[] shtarr = null;
        int[] longarr = null;
        boolean swapped = false;
        if(a.length < b.length) {
            shtarr = a;
            longarr = b;
        } else {
            shtarr = b;
            longarr = a;
            swapped = true;
        }
        
        int max = Integer.MIN_VALUE;
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for(int s: shtarr) {
            int peerInx = findPeer(longarr, x - s);
            if(peerInx == -1) break;
            int peer = longarr[peerInx];
            int sum = s + peer;
            if(sum >= max) {
                max = sum;
                List<int[]> res = map.get(sum);
                if(res == null) {
                    res = new ArrayList<int[]>();
                }
                if(swapped) {
                    res.add(new int[]{peer, s});
                } else {
                    res.add(new int[]{s, peer});
                }
                map.put(sum, res);
            }
        }
        List<int[]> list = map.get(max);
        if(swapped) Collections.reverse(list);
        int[][] ans = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    
    private int findPeer(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while(start + 1 < end) {
            int med = (end - start) / 2 + start;
            
            if(arr[med] == target) {
                return med;
            } else if(arr[med] < target) {
                start = med;
            } else {
                end = med;
            }
        }
        if(arr[end] <= target) {
            return end;
        } else if(arr[start] <= target) {
            return start;
        } else {
            return -1;
        }
    }

}
