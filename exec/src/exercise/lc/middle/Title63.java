package exercise.lc.middle;

/**
 * @author wangtianchuan 2021/6/23
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 输入：obstacleGrid = [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 */
public class Title63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] d = new int[m][n];
        d[0][0] = obstacleGrid[0][0] ^ 1;
        for(int i = 1; i < m; i++){
            if (obstacleGrid[i][0] == 1){
                d[i][0] = 0;
            } else {
                d[i][0] = d[i - 1][0];
            }
        }
        for(int j = 1; j < n; j++){
            if (obstacleGrid[0][j] == 1){
                d[0][j] = 0;
            } else {
                d[0][j] = d[0][j - 1];
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if (obstacleGrid[i][j] == 1){
                    d[i][j] = 0;
                } else {
                    d[i][j] = d[i - 1][j] + d[i][j - 1];
                }
            }
        }
        return d[m - 1][n - 1];
    }
}
