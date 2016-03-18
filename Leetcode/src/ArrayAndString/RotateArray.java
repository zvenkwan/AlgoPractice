package ArrayAndString;
import java.util.Arrays;

/**
 * leetcode 189. Rotate Array
 * @author guanziwen
 *	Rotate an array of n elements to the right by k steps.
 *For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *Note:
 *Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *Hint:
 *Could you do it in-place with O(1) extra space?
 *Related problem: Reverse Words in a String II
 */
public class RotateArray {
	public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int n = nums.length;
        swapArray(nums, 0, n - 1);
        swapArray(nums, 0, k - 1);
        swapArray(nums, k, n - 1);
    }
    
	private void swapArray(int[] s, int begin, int end) {
		while(begin<end){
			int temp = s[begin];
			s[begin] = s[end];
			s[end] = temp;
			begin++;
			end--;
		}
	}
	public static void main(String[] args) {
		int []s = {1,2,3};
		new RotateArray().rotate(s, 4);
		System.out.println(Arrays.toString(s));

	}

}
