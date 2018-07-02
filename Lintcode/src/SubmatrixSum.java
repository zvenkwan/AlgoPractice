
public class SubmatrixSum {
    public int[][] submatrixSum(int[][] matrix) {
        // write your code here
        // restrictions:
        // col and row count can be different
        // all integers
        // use sum[i][j] to hold sum from matrix[0][0] to matrix[i][j]
        int[][] res = new int[2][2];
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int[][] sum = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                sum[i+1][j+1] = matrix[i][j] + sum[i][j+1] + sum[i+1][j] - sum[i][j];
            }
        }
        // to find submatrix starting from [rowi + 1, 0] to [rowj, colf] with sum = sum
        // find submatrix starting from [rowi + 1, 0] to [rowi + 1, colt] with sum also = s
        // this means submatrix from [rowi + 1, colf] to [rowj, colt] sum is 0;
        
        for(int rowf = 0; rowf < matrix.length; rowf++) {
//            for(int rowt = rowf + 1; rowt < matrix)
        }
        return res;
    }
}
