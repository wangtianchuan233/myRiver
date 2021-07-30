package exercise.lc.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtianchuan 2021/7/29
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 输入：n = 4
 * 输出：
 *          [[
 *          ".Q..",
 *          "...Q",
 *          "Q...",
 *          "..Q."
 *          ],[
 *          "..Q.",
 *          "Q...",
 *          "...Q",
 *          ".Q.."
 *          ]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 *
 * 提示：
 * 1 <= n <= 9
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title51 {
    public static void main(String[] args) {
        Title51 t = new Title51();
        int n = 3;
        System.out.println(t.solveNQueens(n));
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] combine = new int[n];
        backtrack(ans, combine, n, 0, 0, 0, 0);
        return ans;
    }

    /**
     * @param ans 最终结果
     * @param combine 正在拼接的数组
     * @param n 行总数
     * @param row 当前行
     * @param l1 记录已经存在数据的列
     * @param l2 记录存在数据的列占掉的对角线 1,1 方向
     * @param l3 记录存在数据的列占掉的对角线 1,-1 方向
     */
    private void backtrack(List<List<String>> ans, int[] combine, int n, int row, int l1, int l2, int l3) {
        if (row == n){
            ans.add(transform(combine));
            return;
        }
        for(int i = 0; i < n; i++) {
            if (((l1 >> i & 1) == 0) && ((l2 >> i & 1) == 0) && ((l3 >> i & 1) == 0)) {
                int cur = 1 << (i);
                l1 += cur;
                l2 += cur;
                l3 += cur;
                combine[row] = i;
                backtrack(ans, combine, n, row + 1, l1, l2 << 1, l3 >> 1);
                combine[row] = 0;
                l1 -= cur;
                l2 -= cur;
                l3 -= cur;
            }
        }
    }

    private List<String> transform(int[] combine) {
        /*
        [ 1 0 ] --> [ .Q ,
                      Q.]
         */
        List<String> ans = new ArrayList<>();
        for (int i : combine) {
            ans.add(transform(i, combine.length));
        }
        return ans;
    }

    private String transform(int i, int n) {
        // 1,3 --> .Q..
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < n; k++){
            if (k == i){
                sb.append('Q');
            } else {
                sb.append(".");
            }
        }
        return new String(sb);
    }
}
