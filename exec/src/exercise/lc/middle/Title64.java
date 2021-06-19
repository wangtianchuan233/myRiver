package exercise.lc.middle;

import java.util.Arrays;

/**
 * @author wangtianchuan 2021/6/19
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 输入：grid =
 * [[1,3,1],
 *  [1,5,1],
 *  [4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 */
public class Title64 {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] last = Arrays.copyOf(grid[0], n);
        for(int i = 1; i < n; i++){
            last[i] += last[i - 1];
        }
        for(int i = 1; i < m; i++){
            int[] cur = Arrays.copyOf(grid[i], n);
            cur[0] += last[0];
            for(int j = 1; j < n; j++){
                cur[j] = cur[j] + Math.min(cur[j - 1], last[j]);
            }
            last = cur;
        }
        return last[n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6}};
        System.out.println(minPathSum(grid));
    }
}
