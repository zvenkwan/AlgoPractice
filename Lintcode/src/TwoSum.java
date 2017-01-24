
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        if(numbers == null || numbers.length <= 1) return new int[]{-1,-1};
        int start = 0;
        int end = numbers.length - 1;
        while(start < end) {
            if(numbers[start] + numbers[end] == target) {
                break;
            } else if(numbers[start] + numbers[end] < target ) {
                start ++;
            } else end--;
        }
        return new int[]{start+1, end+1};
    }
}
