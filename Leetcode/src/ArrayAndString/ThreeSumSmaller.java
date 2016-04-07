package ArrayAndString;
import java.util.Arrays;

/**
 * 259. 3Sum Smaller My Submissions Question
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < 
 * target.
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * Return 2. Because there are two triplets which sums are less than 2:
 * [-2, 0, 1]
 * [-2, 0, 3]
 * Could you solve it in O(n2) runtime?
 * @author guanziwen
 *
 */
public class ThreeSumSmaller {

	public int threeSumSmaller(int[] nums, int target) {
		int count=0;
//      brute force O(n^3)
//		for(int i=0;i<nums.length-2;i++) {
//			for(int j=i+1;j<nums.length-1;j++) {
//				for(int k=j+1;k<nums.length;k++) {
//					if(nums[i]+nums[j]+nums[k]<target)
//						count++;
//				}
//			}
//		}
//		binary search O(n^2logn)
		Arrays.sort(nums);
		for(int i=0;i<nums.length-2;i++) {
			count+=twoSmaller(nums, i+1, target-nums[i]);
		}
		return count;
    }
	private int twoSmaller(int sorted[], int start, int target) {
		int count=0;
		
		
//		method 1, O(n)
		int left=start;
		int right=sorted.length-1;
		while(left<right) {
			if(sorted[left]+sorted[right]<target) {
				count+=right-left;
				left++;
			} else {
				right--;
			}
		}
//		method 2, O(nlogn)
//		for(int i=start;i<nums.length-1;i++) {
////			largest index of sum that smaller than the target
//			int j=binarySearch(nums, i, target);
//			count+=j-i;
//		}
		return count;
	}
	private int binarySearch(int sorted[], int start, int target) {
		System.out.println("start from "+start);
		int left=start;
		int right=sorted.length-1;
		System.out.println("left is "+left+", and right is "+right);
		
		while(left<right) {
			int mid=(left+right+1)/2;
			if(sorted[start]+sorted[mid]<target) {
				left=mid;
			} else {
				right=mid-1;
			}
			System.out.println("left is "+left+", and right is "+right);
		}
		System.out.println("left is "+left);
//		largest index that smaller than the target
		return left;
	}
	
	public static void main(String[] args) {
		int nums[] = {0,-4,-1,1,-1,2};
		System.out.println(new ThreeSumSmaller().threeSumSmaller(nums ,-5));

	}

}
