
public class MaximumAverageSubarray {
	public static void main(String[] args) {
		int[] a = new int[]{-1,-2,-3,-100,-1,-50,-2};
		MaximumAverageSubarray m = new MaximumAverageSubarray();
		System.out.println(m.maxAverage(a, 4));
	}
	
	public double maxAverage(int[] nums, int k) {
        // Write your code here
        double l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] < l)
                l = nums[i];
            if (nums[i] > r)
                r = nums[i];
        }

        double[] sum = new double[n + 1];
        sum[0] = 0;
        while (r - l >= 1e-6) {
            double mid = (l + r) / 2.0;

            double min_pre = 0;
            boolean check = false;
            for (int i = 1; i <= n; ++i) {
                sum[i] = sum[i - 1] + nums[i - 1] - mid;
//                if (i >= k && sum[i] - min_pre >= 0) {
                	if (i >= k && sum[i] - min_pre <= 0) {
                    check = true;
                    break;
                }
                if (i >= k)
                    min_pre = Math.max(min_pre, sum[i - k + 1]);
//                min_pre = Math.min(min_pre, sum[i - k + 1]);
            }
            if (check)
                r = mid;
            else
                l = mid;
//            if (check)
//            	l = mid;
//            else
//            	r = mid;
        }

        return l;
    }
}
