package exercise.ms;

/**
 * @author wangtianchuan 2021/6/15
 * 
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，
 * 因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例 1：
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 *
 * 示例 2：
 *
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 *
 * 示例 3：
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title17x16 {
    public int massage(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] f = new int[len];
        f[0] = nums[0];
        if (len == 1) return f[0];
        f[1] = nums[1];
        if (len == 2) return Math.max(f[1], f[0]);
        f[2] = nums[2] + nums[0];
        for(int i = 3; i < len; i++){
            f[i] = nums[i] + Math.max(f[i - 2], f[i - 3]);
        }
        return Math.max(f[len - 1], f[len - 2]);
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,1};
        System.out.println(new Title17x16().massage(nums));
    }
}




















