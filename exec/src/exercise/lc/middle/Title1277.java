package exercise.lc.middle;

/**
 * @author wangtianchuan
 *
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，
 * 请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 */
public class Title1277 {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        System.out.println(countSquares(matrix));
    }
    public static int countSquares(int[][] matrix) {
        int count = 0;
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++){
            if (matrix[i][0] == 1){
                count++;
            }
        }
        for(int j = 1; j < n; j++){
            if (matrix[0][j] == 1){
                count++;
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if (matrix[i][j] == 1){
                    matrix[i][j] = 1 + Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1]));
                    count += matrix[i][j];
                }
            }
        }
        return count;
    }
}
