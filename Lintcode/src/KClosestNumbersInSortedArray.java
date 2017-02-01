import java.util.Arrays;

/**
 * Given a target number, a non-negative integer k and an integer array A sorted in ascending order, find the k closest numbers to target in A, sorted in ascending order by the difference between the number and target. Otherwise, sorted in ascending order by number if the difference is same.

Have you met this question in a real interview? Yes
Example
Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].

Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].
 * @author zg55
 *
 */
public class KClosestNumbersInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = new int[]{1,2,3};
		int target = 2;
		int k = 4;
		
		KClosestNumbersInSortedArray kc = new KClosestNumbersInSortedArray();
		int[] res = kc.kClosestNumbers(A, target, k);
		System.out.println(Arrays.toString(res));
	}
	
	public int[] kClosestNumbers(int[] A, int target, int k) {
        // Write your code here
        if(A == null || A.length == 0) return new int[0];
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] >= target) {
                end = mid;
            } else 
                start = mid;
        }
        int index = 0;
        if(target - A[start] <= A[end] - target) {
            index = start;
        } else
            index = end;
        int[] res = new int[Math.min(k,A.length)];
        System.out.println("index is "+index);
        int a = index - 1;
        int b = index;
        for(int i=0; i < k; i++) {
            if(a >= 0 && b <= A.length-1) {
                if(target - A[a] <= A[b] - target) 
                    res[i] = A[a--];
                else
                    res[i] = A[b++];
            }
            else if(a >= 0) {
                res[i] = A[a--];
            }
            else if(b <= A.length - 1) {
                res[i] = A[b++];
            }
            else break;
        }
        return res;
    }
}
