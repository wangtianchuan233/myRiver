package exercise.lc.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangtianchuan 2021/7/26
 * 给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 * 注意：解集不能包含重复的组合。
 *
 * 示例1:
 *
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * 提示:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class Title40 {

    public static void main(String[] args) {
        int[] c = {10,1,2,7,6,1,5};
//        int[] c = {1,2,1,3};
        System.out.println(new Title40().combinationSum2(c, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        List<int[]> freq = new ArrayList<>();
        Arrays.sort(candidates);
        for (int num : candidates) {
            int size = freq.size();
            if (size == 0 || num != freq.get(size - 1)[0]){
                freq.add(new int[]{num, 1});
            } else {
                freq.get(size - 1)[1]++;
            }
        }
        backtrack(candidates, target, list, perm, freq, 0);
        return list;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> list, List<Integer> perm, List<int[]> freq, int index) {
        if (target == 0){
            list.add(new ArrayList<>(perm));
            return;
        }


        if (index == freq.size() || target < freq.get(index)[0]){
            return;
        }

        int[] arr = freq.get(index);

        backtrack(candidates, target, list, perm, freq, index + 1);

        int most = Math.min(target / arr[0], arr[1]);
        for(int i = 1; i <= most; i++){
            perm.add(arr[0]);
            backtrack(candidates, target - i * arr[0], list, perm, freq, index + 1);
        }
        for(int i = 1; i <= most; i++){
            perm.remove(perm.size() - 1);
        }
    }
}
