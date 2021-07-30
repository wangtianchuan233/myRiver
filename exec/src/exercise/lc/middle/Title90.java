package exercise.lc.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangtianchuan 2021/7/30
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title90 {
    public static void main(String[] args) {
        int[] nums = {2,2,2};
        Title90 t = new Title90();
        System.out.println(t.subsetsWithDup(nums));
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(subsets, subset, nums, 0, vis);
        return subsets;
    }

    private void backtrack(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int index, boolean[] vis) {
        if (index == nums.length){
            subsets.add(new ArrayList<>(subset));
            return;
        }
        // 不添加当前元素
        backtrack(subsets, subset, nums, index + 1, vis);
        // 添加当前元素, 当元素重复时, 每次添加的必须是从左往右排列的第一个没有添加的该元素
        if (index > 0 && nums[index] == nums[index - 1] && !vis[index - 1]){
            // 不添加当前元素
        } else {
            subset.add(nums[index]);
            vis[index] = true;
            backtrack(subsets, subset, nums, index + 1, vis);
            subset.remove(subset.size() - 1);
            vis[index] = false;
        }
    }
}
