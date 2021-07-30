package exercise.lc.hard;

/**
 * @author wangtianchuan 2021/7/30
 *
 * 在二维网格 grid 上，有 4 种类型的方格：
 *
 * 1 表示起始方格。且只有一个起始方格。
 * 2 表示结束方格，且只有一个结束方格。
 * 0 表示我们可以走过的空方格。
 * -1 表示我们无法跨越的障碍。
 * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。
 *
 * 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。
 */
public class Title980 {
    public static void main(String[] args) {
//        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
//        int[][] grid = {{1,0,0},{0,0,0},{0,0,2}};
//        int[][] grid = {{1,0},{0,0},{0,2}};
        int[][] grid = {{0,1},{2,0}};
        Title980 title980 = new Title980();
        System.out.println(title980.uniquePathsIII(grid));
    }
    public int uniquePathsIII(int[][] grid) {
        int[] d = screen(grid);
        return backtrack(grid, 0, -1, d[0], d[1], d[2]);
    }

    private int backtrack(int[][] grid, int ans, int count, int len, int x, int y) {
        int t = grid[x][y];
        if (grid[x][y] == 2){
            if (count == len) {
                ++ans;
            }
            return ans;
        }

        // 向上
        if (x > 0 && grid[x - 1][y] != -1){
            grid[x][y] = -1;
            ans = backtrack(grid, ans, count + 1, len, x - 1, y);
            grid[x][y] = t;
        }
        // 向右
        if (y < grid[0].length - 1 && grid[x][y + 1] != -1){
            grid[x][y] = -1;
            ans = backtrack(grid, ans, count + 1, len, x, y + 1);
            grid[x][y] = t;
        }
        // 向下
        if (x < grid.length - 1 && grid[x + 1][y] != -1){
            grid[x][y] = -1;
            ans = backtrack(grid, ans, count + 1, len, x + 1, y);
            grid[x][y] = t;
        }
        // 向左
        if (y > 0 && grid[x][y - 1] != -1){
            grid[x][y] = -1;
            ans = backtrack(grid, ans, count + 1, len, x, y - 1);
            grid[x][y] = t;
        }
        return ans;
    }

    private int[] screen(int[][] grid) {
        int[] ans = new int[3];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0){
                    ans[0] ++;
                } else if (grid[i][j] == 1){
                    ans[1] = i;
                    ans[2] = j;
                }
            }
        }
        return ans;
    }
}
