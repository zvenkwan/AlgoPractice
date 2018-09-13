import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author zg55
 *54. Spiral Matrix
DescriptionHintsSubmissionsDiscussSolution
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        while(left <= right || up <= down) {
                
            if(up <= down) {
                iterateUp(result, left, right, up, matrix);
                up++;
            }
            if(left <= right) {
                iterateRight(result, up, down, right, matrix);
                right--;
            }
            if(up <= down) {
                iterateDown(result, right, left, down, matrix);
                down--;
            }
            if(left <= right) {
                iterateLeft(result, down, up, left, matrix);
                left++;
            }
        }
        return result;
    }
    
    private void iterateUp(List<Integer> result, int left, int right, int up, int[][] matrix) {
        if(left > right) return;
        for(int i = left; i <= right; i++) {
            result.add(matrix[up][i]);
        }
    }
    private void iterateRight(List<Integer> result, int up, int down, int right, int[][] matrix) {
        if(up > down) return;
        for(int i = up; i <= down; i++) {
            result.add(matrix[i][right]);
        }
    }
    private void iterateDown(List<Integer> result, int right, int left, int down, int[][] matrix) {
        if(right < left) return;
        for(int i = right; i >= left; i--) {
            result.add(matrix[down][i]);
        }
    }
    private void iterateLeft(List<Integer> result, int down, int up, int left, int[][] matrix) {
        if(down < up) return;
        for(int i = down; i >= up; i--) {
            result.add(matrix[i][left]);
        }
    }
}
