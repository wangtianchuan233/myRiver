package exercise.lc.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtianchuan 2021/7/26
 *
 * 给定一个无重复元素的正整数数组candidates和一个正整数target，找出candidates中所有可以使数字和为目标数target的唯一组合。
 *
 * candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 *
 * 对于给定的输入，保证和为target 的唯一组合数少于 150 个。
 *
 * 
 *
 * 示例1：
 *
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title39 {
    public static void main(String[] args) {
        int[] c = {2,3,6,7};
        System.out.println(combinationSum(c, 7));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        backtrack(list, perm, candidates, target, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> perm, int[] candidates, int target, int index) {
        if (index == candidates.length){
            return;
        }
        if (target == 0){
            list.add(new ArrayList<>(perm));
            return;
        }
        // 不选当前数
        backtrack(list, perm, candidates, target, index + 1);
        // 选当前数
        if (target >= candidates[index]){
            perm.add(candidates[index]);
            backtrack(list, perm, candidates, target - candidates[index], index);
            perm.remove(perm.size() - 1);
        }
    }
}
