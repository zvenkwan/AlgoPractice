package ArrayAndString;
/**
 * 303. Range Sum Query - Immutable
 * @author zg55
 *Given an integer array nums, find the sum of the elements between indices i and j (i ¡Ü j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 */
public class RangeSumQuery {
//	considering the method will be called many times,
//	save the sum of first n elements in an array sum[] at n+1 with first sum[0]=0
    private int sum[];
    public RangeSumQuery(int[] nums) {
        this.sum=new int[nums.length+1];
        sum[0]=0;
        for(int i=0;i<nums.length;i++) {
            sum[i+1]=nums[i]+sum[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1]-sum[i];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//Your NumArray object will be instantiated and called as such:
//NumArray numArray = new NumArray(nums);
//numArray.sumRange(0, 1);
//numArray.sumRange(1, 2);