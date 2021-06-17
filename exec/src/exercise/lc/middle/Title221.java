package exercise.lc.middle;

/**
 * @author wangtianchuan 2021/6/17
 *
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class Title221 {
    public static int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] d = new int[m][n];
        for(int i = 0; i < m; i++){
            d[i][0] = matrix[i][0] - '0';
            max = Math.max(max, d[i][0]);
        }
        for(int j = 0; j < n; j++){
            d[0][j] = matrix[0][j] - '0';
            max = Math.max(max, d[0][j]);
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if (matrix[i][j] == '0'){
                    //d[i][j] = 0;
                } else {
                    d[i][j] = Math.min(d[i][j - 1], d[i - 1][j]);
                    d[i][j] = Math.min(d[i][j], d[i - 1][j - 1]);
                    d[i][j]++;
                    max = Math.max(max, d[i][j]);
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        char[][] nums = {{'0', '1'},{'1','0'}};
        maximalSquare(nums);
    }
}
