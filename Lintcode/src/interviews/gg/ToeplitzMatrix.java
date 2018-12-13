package interviews.gg;
/**
 * 
 * @author jguan
 *1042. Toeplitz Matrix
A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

Now given an M x N matrix, return True if and only if the matrix is Toeplitz.

Example
Example 1:

Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
Output: True
Explanation:
1234
5123
9512

In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]", and in each diagonal all elements are the same, so the answer is True.


Example 2:

Input: matrix = [[1,2],[2,2]]
Output: False
Explanation:
The diagonal "[1, 2]" has different elements.
Notice
matrix will be a 2D array of integers.
matrix will have a number of rows and columns in range [1, 20].
matrix[i][j] will be integers in range [0, 99].
 */
public class ToeplitzMatrix {
    /**
     * @param matrix: the given matrix
     * @return: True if and only if the matrix is Toeplitz
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        // Write your code here
        
        // starting from bottom to the Top 
        // M x N 
        // check if all the values except first row and first col == [row-1][col-1]
        
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        if(matrix.length == 1 || matrix[0].length == 1) return true;
        
        int m = matrix.length;
        int n = matrix[0].length;
        for(int r = 1; r < m; r++) {
            for( int c = 1; c < n; c++) {
                if(matrix[r][c] != matrix[r - 1][c - 1]) {
                    return false;
                }
            }
        }
        return true;
    }


}
