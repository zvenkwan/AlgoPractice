import java.util.HashMap;
import java.util.Map;

public class SubmatrixSum {
    public int[][] submatrixSum(int[][] matrix) {
        // write your code here
        // restrictions:
        // col and row count can be different
        // all integers
        // use sum[i][j] to hold sum from matrix[0][0] to matrix[i][j]
        int[][] res = new int[2][2];
        int m = matrix.length;
        int n = matrix[0].length;
        if(matrix == null || m == 0 || n == 0) {
            return res;
        }
        int[][] sum = new int[m + 1][n + 1];
        for (int j=0; j<=n; ++j) sum[0][j] = 0;
        for (int i=1; i<=m; ++i) sum[i][0] = 0;
        for(int i = 0 ; i < m; i++) {
            for(int j = 0; j < n; j++) {
                sum[i+1][j+1] = matrix[i][j] + sum[i][j+1] + sum[i+1][j] - sum[i][j];
            }
        }
        // find submatrix starting from [rowi + 1, 0] to [rowj, colf] with sum = sum
        // find submatrix starting from [rowi + 1, 0] to [rowi + 1, colt] with sum also = s
        // this means submatrix from [rowi + 1, colf] to [rowj, colt] sum is 0;
        
        for(int rowf = 0; rowf < m; rowf++) {
            for(int rowt = rowf + 1; rowt <= m; rowt++) {
                Map<Integer, Integer> map = new HashMap<>();
                for(int colf = 0; colf <= n; colf++) {
                    int subsum = sum[rowt][colf] - sum[rowf][colf];
                    if(map.containsKey(subsum)) {
                        res[0][0] = rowf;
                        res[0][1] = map.get(subsum);
                        
                        res[1][0] = rowt - 1;
                        res[1][1] = colf - 1; //matrix index, so minus 1
                    } else {
                        map.put(subsum, colf);
                    }
                }
            }
        }
        return res;
    }
}
