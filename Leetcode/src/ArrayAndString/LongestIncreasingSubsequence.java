package ArrayAndString;
import java.util.Arrays;
/**
 * 300. Longest Increasing Subsequence
 * @author zg55
 *Given an unsorted array of integers, find the length of longest increasing subsequence.
 *For example,Given [10, 9, 2, 5, 3, 7, 101, 18],
 *The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return 
 *the length.
 *Your algorithm should run in O(n2) complexity.
 *Follow up: Could you improve it to O(n log n) time complexity?
 *
 */
public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
//		O(n^2)
//		int[] ls = new int[nums.length];
//		for(int i=0; i<nums.length;i++) {
//			ls[i]=1;
////			look for smaller number in ahead of nums[i]
//			for(int j=0;j<i;j++) {
//				if(nums[j]<nums[i]&&ls[j]>=ls[i]) {
//					ls[i]=ls[j]+1;
//					System.out.println(Arrays.toString(ls));
//				}
//			}
//		}
//		int longest=0;
//		for(int i=0; i<ls.length;i++) {
//			longest=longest>ls[i]?longest:ls[i];
//		}
//		return longest;
		if(nums.length==0){
			return 0;
		}

		int[] result = new int[nums.length+1];
		int currentLength = 0;
		result[0] = Integer.MIN_VALUE;
		for(int i = 0;i<nums.length;i++){
		    int pre = binarySearch(result,0,currentLength,nums[i]);
		    if(result[pre]==nums[i]){
		        continue;
		    }
		    result[++pre] = nums[i];
		    System.out.println("the result is "+Arrays.toString(result));
		    if(pre>currentLength){
		        currentLength =pre;
		    }
		}
		return currentLength;
    }
	
	public int binarySearch(int[] a, int p, int r, int t){
	    while(p<=r){
	        int q = (p+r)/2;
	        if(t<a[q]){
	            r = q-1;
	        }else{
	            p = q+1;
	        }
	    }
	    return r;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]={10, 9, 2, 5, 3, 7, 101, 18};
		int l = new LongestIncreasingSubsequence().lengthOfLIS(nums);
		System.out.println(l);
	}

}
