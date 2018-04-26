/**
 * 
 * @author jguan
 *28. Search a 2D Matrix 
 Description
 Notes
 Testcase
 Judge
Discuss 
Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Have you met this question in a real interview? 
Example
Consider the following matrix:

[
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
]
Given target = 3, return true.

Challenge 
O(log(n) + log(m)) time
 */
public class Searcha2DMatrix {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rs = 0;
        int re = matrix.length - 1;
        while(rs + 1 < re) {
            int m = rs + (re-rs)/2;
            if(matrix[m][0] == target)
                return true;
            else if(matrix[m][0] < target) 
                rs = m;
            else
                re = m;
        }
        int r = 0;
        if(matrix[re][0] <= target) r = re;
        else r = rs;
        
        int cs = 0;
        int ce = matrix[r].length - 1;
        while(cs + 1 < ce) {
            int m = cs + (ce - cs)/2;
            if(matrix[r][m] == target)
                return true;
            else if(matrix[r][m] < target) 
                cs = m;
            else
                ce = m;
        }
        if(matrix[r][cs] == target || matrix[r][ce] == target) return true;
        return false;
    }
}
