package exercise.lc.middle;

import util.Printer;

/**
 * @author wangtianchuan 2021/8/13
 *
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 
 * 输入：board = [
 * ["X","X","X","X"],
 * ["X","O","O","X"],
 * ["X","X","O","X"],
 * ["X","O","X","X"]
 * ]
 *
 * 输出：[
 * ["X","X","X","X"],
 * ["X","X","X","X"],
 * ["X","X","X","X"],
 * ["X","O","X","X"]
 * ]
 *
 * 解释：
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的'O'都不会被填充为'X'。
 * 任何不在边界上，或不与边界上的'O'相连的'O'最终都会被填充为'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
public class Title130 {
    public static void main(String[] args) {
        char[][] board = {
                {'O','X','X','O','X'},
                {'X','O','O','X','O'},
                {'X','O','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','X','O'}
        };
        Printer.printArrayAsMatrix(board);
        Printer.horizontalLine();
        Title130 t = new Title130();
        t.solve(board);
        Printer.printArrayAsMatrix(board);
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (m < 3 || n < 3){
            return;
        }
        for(int i = 0; i < m; i ++){
            dfs(board, m, n, i, 0);
            dfs(board, m, n, i, n - 1);
        }
        for(int j = 0; j < n; j ++){
            dfs(board, m, n, 0, j);
            dfs(board, m, n, m - 1, j);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if (board[i][j] == '/'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n){
            return;
        }
        if (board[i][j] == 'X'){
            return;
        }
        if (board[i][j] == '/'){
            return;
        }
        if (board[i][j] == 'O'){
            board[i][j] = '/';
            dfs(board, m, n, i + 1, j);
            dfs(board, m, n, i - 1, j);
            dfs(board, m, n, i, j + 1);
            dfs(board, m, n, i, j - 1);
        }
    }
}
