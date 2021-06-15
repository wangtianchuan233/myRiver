package exercise.lc.easy;

import java.util.Arrays;

/**
 * @author wangtianchuan
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 *
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * 
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title977 {
    public static void main(String[] args) {

    }
    /*
        时间 59.3%, 空间 75%
        TODO 有空复习一下排序
     */
    public int[] sortedSquares(int[] nums) {
        int k;
        for (int i = 0; i < nums.length; i++) {
            k = nums[i];
            nums[i] = k * k;
        }
        Arrays.sort(nums);
        return nums;
    }
}