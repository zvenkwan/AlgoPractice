package ArrayAndString;
/**
 * 41. First Missing Positive
 * @author zg55
 *	Given an unsorted integer array, find the first missing positive integer.
 *	For example,
 *	Given [1,2,0] return 3,
 *	and [3,4,-1,1] return 2.
 *	Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
        if(nums.length==0)
        	return 1;
        for(int i=0; i< nums.length;) {
        	if(nums[i]<=0 || nums[i]>nums.length || (nums[nums[i]-1]==nums[i]&&nums[i]-1!=i)) {
        		nums[i]=0;
        		i++;
        	} else {
	        	if(nums[i]!=i+1) {
	        		int temp=nums[i];
	        		nums[i]=nums[nums[i]-1];
	        		nums[temp-1]=temp;
	        	}
	        	else
	        		i++;
        	}
        }
        int miss=0;
        for(miss=0;miss<nums.length;miss++) {
        	if(nums[miss]!=miss+1) {
        		break;
        	}
        }
        return miss+1;
    }
	public static void main(String[] args) {
		int nums[] = {1};
		int miss=new FirstMissingPositive().firstMissingPositive(nums);
		System.out.println(miss);
	}

}
