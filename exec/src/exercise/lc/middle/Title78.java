package exercise.lc.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtianchuan 2021/7/30
 * 
 * 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Title78 t = new Title78();
        System.out.println(t.subsets(nums));
    }
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        backtrack(ans, subset, nums, 0);
        return ans;
    }

    private void backtrack(ArrayList<List<Integer>> ans, ArrayList<Integer> subset, int[] nums, int index) {
        if (index == nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }
        // 不添加第 index 个元素
        backtrack(ans, subset, nums, index + 1);
        // 添加第 index 个元素
        subset.add(nums[index]);
        backtrack(ans, subset, nums, index + 1);
        subset.remove(subset.size() - 1);
    }
}
