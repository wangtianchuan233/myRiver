package exercise.lc.easy;

/**
 * @author wangtianchuan
 * 给你一个 m * n的矩阵grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
 *
 * 请你统计并返回grid中 负数 的数目。
 *
 * 示例 1：
 * 输入：grid = [[4,  3,  2, -1],
 *              [3,  2,  1, -1],
 *              [1,  1, -1, -2],
 *              [-1,-1, -2, -3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 *
 * 示例 2：
 * 输入：grid = [[3,2],
 *              [1,0]]
 * 输出：0
 *
 * 示例 3：
 * 输入：grid = [[1, -1],
 *              [-1,-1]]
 * 输出：3
 *
 * 示例 4：
 * 输入：grid = [[-1]]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title1351 {
    public static void main(String[] args) {
        int[][] grid = new int[2][2];
        // grid[0][0] = 3;
        // grid[0][1] = 2;
        // grid[1][0] = 1;
        // grid[1][1] = 0;
        grid[0][0] = 1;
        grid[0][1] = -1;
        grid[1][0] = -1;
        grid[1][1] = -1;
        System.out.println(new Title1351().m(grid));
    }

    private int m(int[][] grid) {
        int res = 0;
        int m = grid.length, n = 0;
        if (m > 0){
            n = grid[0].length;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0){
                    res += (n - j);
                    break;
                }
            }
        }
        return res;
    }
}
