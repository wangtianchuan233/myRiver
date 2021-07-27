package exercise.lc.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtianchuan 2021/7/27
 * 
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *
 * 提示：
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title77 {
    public static void main(String[] args) {
        Title77 t = new Title77();
        int n = 4, k = 2;
        System.out.println(t.combine(n, k));
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        backtrack(n, k, list, one, 1);
        return list;
    }

    private void backtrack(int n, int k, List<List<Integer>> list, List<Integer> one, int index) {
        if (one.size() == k){
            list.add(new ArrayList<>(one));
            return;
        }
        for(int i = index; i <= n; i++){
            one.add(i);
            backtrack(n, k, list, one, i + 1);
            one.remove(one.size() - 1);
        }
    }
}
