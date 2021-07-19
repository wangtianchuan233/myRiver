package exercise.lc.middle;

/**
 * @author wangtianchuan 2021/7/19
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，
 * 一夜之内能够偷窃到的最高金额。
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *     偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title198 {
    public static void main(String[] args) {
        int[] a = {1,2,3,1};
        System.out.println(rob(a));
    }
    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return 0;
        }
        int a = nums[0];
        int b = 0;
        // 如果 第 i 天抢, 那么第 i - 1 天必定不抢, 则第 i 天抢完后的财富为 nums[i] + b[i - 1]
        // 如果 第 i 天不抢, 那么第 i - 1 天可以抢也可以不抢, 则第 i 天的财富为 a[i - 1] 或 b[i - 1]
        for(int i = 1; i < len; i++){
            int ta = a, tb = b;
            a = nums[i] + tb;
            b = Math.max(ta, tb);
        }
        return Math.max(a, b);
    }
}
