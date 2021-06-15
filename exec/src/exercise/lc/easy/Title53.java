package exercise.lc.easy;

/**
 * @author wangtianchuan 2021/6/15
 * 
 * 给定一个整数数组 numsa，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Title53().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        return m(nums, 0, nums.length - 1)[2];
    }

    public int[] m(int[] nums, int l, int r){
        // {lsum, rsum, msum ,isum}
        int[] res = new int[4];
        if (l == r){
            res[0] = res[1] = res[2] = res[3] = nums[l];
        } else {
            int m = (l + r) / 2;
            int[] lres = m(nums, l, m);
            int[] rres = m(nums, m + 1, r);

            // isum
            res[3] = lres[3] + rres[3];

            // lsum
            res[0] = Math.max(lres[0], lres[3] + rres[0]);

            // rsum
            res[1] = Math.max(rres[1], rres[3] + lres[1]);

            // msum
            int max = Math.max(lres[2], rres[2]);
            max = Math.max(max, lres[1] + rres[0]);
            res[2] = max;
        }
        return res;
    }
}
