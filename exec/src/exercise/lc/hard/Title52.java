package exercise.lc.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtianchuan 2021/7/30
 * 
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title52 {
    public static void main(String[] args) {
        Title52 t = new Title52();
        int n = 8;
        System.out.println(t.solveNQueens(n));
    }
    public int solveNQueens(int n) {
        return backtrack(0, n, 0, 0, 0, 0);
    }

    private int backtrack(int ans, int n, int row, int l1, int l2, int l3) {
        if (row == n){
            ans += 1;
            return ans;
        }
        for(int i = 0; i < n; i++) {
            if (((l1 >> i & 1) == 0) && ((l2 >> i & 1) == 0) && ((l3 >> i & 1) == 0)) {
                int cur = 1 << (i);
                l1 += cur;
                l2 += cur;
                l3 += cur;
                ans = backtrack(ans, n, row + 1, l1, l2 << 1, l3 >> 1);
                l1 -= cur;
                l2 -= cur;
                l3 -= cur;
            }
        }
        return ans;
    }
}
