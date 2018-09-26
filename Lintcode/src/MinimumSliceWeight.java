import java.util.List;

/**
 * 
 * @author jguan
 *Given an NxN matrix, slice it and find the minimum slice weight.

A slice consists of all the elements that are below, below right, or below left of the element above it. The Min Slice Weight is the minimum sum of all elements in the slice.

Example: given input

1 2 3

4 5 6

7 8 9

The slices would be 1 4 7; 1 4 8; 1 5 7; 1 5 8; 1 5 9; 2 4 7; 2 4 8; 2 5 8; 2 5 9;2 6 8; 2 6 9 ....etc.

The minimum slice would be 1 4 7 because 1+4+7 is the minimum of all the sums;

Write a function public int FindMinSlice (List<List<Integer>> Matrix) that returns the min slice weight.
 */
public class MinimumSliceWeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	use a matrix to store that m[i][j] = min sum of row 0 to row i element j 
	public int FindMinSlice (List<List<Integer>> matrix) {
		if(matrix == null || matrix.size() == 0 || matrix.get(0).size() == 0) return 0;
		int n = matrix.size();
		int[][] sum = new int[n][n];
		for(int c = 0; c < n; c++) {
			sum[0][c] = matrix.get(0).get(c);
		}
		/**
		 * only last row were used, we can store pre row sum to an arr[] instead of using arr[][]
		 */
		
		for(int r = 1; r < n ; r++) {
			for(int c = 0; c < n ; c++) {
				if(c == 0) {
//					c and c+1
					sum[r][c] = matrix.get(r).get(c) + Math.min(sum[r-1][c], sum[r-1][c+1]);
				} else if(c == n - 1) {
//					c and c-1
					sum[r][c] = matrix.get(r).get(c) + Math.min(sum[r-1][c], sum[r-1][c-1]);
				} else {
//					c-1 and c and c+1
					sum[r][c] = matrix.get(r).get(c) + Math.min(Math.min(sum[r-1][c], sum[r-1][c-1]) ,sum[r-1][c+1] );
				}
			}
		}
		int min = Integer.MAX_VALUE;
//		find min from the last row
		for(int c = 0; c < n; c++) {
			min = Math.min(min, sum[n - 1][c]);
		}
		return min;
	}
}
