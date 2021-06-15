package exercise.lc.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangtianchuan
 * 给你一个 m x n 的矩阵，最开始的时候，每个单元格中的值都是 0。
 * <p>
 * 另有一个二维索引数组indices，indices[i] = [ri, ci] 指向矩阵中的某个位置，其中 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 * <p>
 * 对 indices[i] 所指向的每个位置，应同时执行下述增量操作：
 * <p>
 * ri 行上的所有单元格，加 1 。
 * ci 列上的所有单元格，加 1 。
 * 给你 m、n 和 indices 。请你在执行完所有indices指定的增量操作后，返回矩阵中 奇数值单元格 的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, indices = [[0,1],
 * [1,1]]
 * 输出：6
 * 解释：最开始的矩阵是 [[0,0,0],
 * [0,0,0]]。
 * 第一次增量操作后得到 [[1,2,1],
 * [0,1,0]]。
 * 最后的矩阵是 [[1,3,1],
 * [1,3,1]]，里面有 6 个奇数。
 * <p>
 * 示例 2：
 * 输入：m = 2, n = 2, indices = [[1,1],
 * [0,0]]
 * 输出：0
 * 解释：最后的矩阵是 [[2,2],
 * [2,2]]，里面没有奇数。
 * <p>
 * <p>
 * 提示：
 * 1 <= m, n <= 50
 * 1 <= indices.length <= 100
 * 0 <= ri < m
 * 0 <= ci < n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cells-with-odd-values-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title1252 {

    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int[][] indices = new int[][]{{1, 1}, {0, 1}};
        System.out.println(new Title1252().oddCells3(m, n, indices));
    }

    // 弃用
    public int oddCells1(int m, int n, int[][] indices) {
        int res = 0;
        int[][] e = new int[m][n];
        for (int i = 0; i < indices.length; i++) {
            for (int j = 0; j < m; j++) {
                // 全列 + 1
                e[j][indices[i][1]]++;
            }
            for (int j = 0; j < n; j++) {
                // 整行 + 1
                e[indices[i][0]][j]++;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (e[i][j] % 2 == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    // 弃用
    public int oddCells2(int m, int n, int[][] indices) {
        Map<Integer, Integer> rows = new HashMap<>();
        Map<Integer, Integer> columns = new HashMap<>();
        for (int[] index : indices) {
            if (rows.containsKey(index[0])) {
                rows.put(index[0], rows.get(index[0]) + 1);
            } else {
                rows.put(index[0], 1);
            }
            if (columns.containsKey(index[1])) {
                columns.put(index[1], columns.get(index[1]) + 1);
            } else {
                columns.put(index[1], 1);
            }
        }
        int oddRows = 0;
        int oddColumns = 0;
        for (Map.Entry<Integer, Integer> entry : rows.entrySet()) {
            oddRows += entry.getValue() % 2;
        }
        for (Map.Entry<Integer, Integer> entry : columns.entrySet()) {
            oddColumns += entry.getValue() % 2;
        }
        return oddRows * n + oddColumns * m - oddRows * oddColumns * 2;
    }

    public int oddCells3(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] columns = new int[n];
        for (int i = 0; i < indices.length; i++) {
            rows[indices[i][0]]++;
            columns[indices[i][1]]++;
        }
        int oddRows = 0;
        int oddColumns = 0;
        for (int i = 0; i < rows.length; i++) {
            oddRows += rows[i] % 2;
        }
        for (int i = 0; i < columns.length; i++) {
            oddColumns += columns[i] % 2;
        }
        return oddRows * n + oddColumns * m - oddRows * oddColumns * 2;
    }
}
