package exercise.lc.middle;

/**
 * @author wangtianchuan 2021/7/19
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * 示例1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *     偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 * 
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title213 {
    public static void main(String[] args) {
        int[] a = {2,3,2, 4, 1};
        System.out.println(rob(a));
    }
    public static int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int len = nums.length - 1;
        int[] a = new int[len];
        int[] b = new int[len];
        a[0] = nums[0];
        for(int i = 1; i < len; i++){
            a[i] = nums[i] + b[i - 1];
            b[i] = Math.max(a[i - 1], b[i - 1]);
        }
        int[] c = new int[len];
        int[] d = new int[len];
        c[0] = nums[1];
        for(int i = 1; i < len; i++){
            c[i] = nums[i+1] + d[i - 1];
            d[i] = Math.max(c[i - 1], d[i - 1]);
        }
        return Math.max(Math.max(a[len - 1], b[len - 1]), Math.max(c[len - 1], d[len - 1]));
    }
}
