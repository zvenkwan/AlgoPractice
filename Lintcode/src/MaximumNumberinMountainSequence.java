
public class MaximumNumberinMountainSequence {

	public int mountainSequence(int[] nums) {
		int s = 0;
		int e = nums.length - 1;
		while(s+1<e) {
			int m = s+(e-s)/2;
			if(nums[m] < nums[m+1]) {
				s = m;
			} else {
				e = m;
			}
		}
		return nums[s]>nums[e]?nums[s]:nums[e];
	}
}
