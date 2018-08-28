/**
 * 
 * @author jguan
 *
38. Search a 2D Matrix II
Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

This matrix has the following properties:

Integers in each row are sorted from left to right.
Integers in each column are sorted from up to bottom.
No duplicate integers in each row or column.
Example
Consider the following matrix:

[
  [1, 3, 5, 7],
  [2, 4, 7, 8],
  [3, 5, 9, 10]
]
Given target = 3, return 2.

Challenge
O(m+n) time and O(1) extra space
 */
public class Searcha2DMatrixII {

    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int r = 0;
        int c = n - 1;
        int count = 0;
        while(r < m && c >= 0) {
            int val = matrix[r][c];
            if(val == target) {
                count++;
                r++;
                c--;
            } else if(val < target) {
                r++;
            } else {
                c--;
            }
        }
        return count;
    }
}
