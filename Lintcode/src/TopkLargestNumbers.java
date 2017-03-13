import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TopkLargestNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {3,10,1000,-99,4,100};
		int k =  3;
		
		System.out.println(Arrays.toString(new TopkLargestNumbers().topk(nums, k)));
	}
	public int[] topk(int[] nums, int k) {
        
        if(nums == null || nums.length == 0) return new int[0];
        if(k >= nums.length) return nums;
        // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        });
        for(int n: nums) {
            pq.add(n);
        }
        int[] res = new int[k];
        for(int i= 0; i < res.length; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
