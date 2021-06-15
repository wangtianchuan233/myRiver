package exercise.lc.easy;

import java.util.Arrays;

/**
 * @author wangtianchuan
 * 给你一个整数n，请你返回 任意一个由 n 个 各不相同的整数组成的数组，并且这 n 个数相加和为 0 。
 *
 * 示例 1：
 * 输入：n = 5
 * 输出：[-7,-1,1,3,4]
 * 解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：[-1,0,1]
 *
 * 示例 3：
 * 输入：n = 1
 * 输出：[0]
 *
 * 提示：
 *
 * 1 <= n <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title1304 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Title1304().sumZero(1)));
    }
    public int[] sumZero(int n) {
        int[] res = new int[n];
        if (n % 2 == 1) {
            res[n - 1] = 0;
            n--;
        }
        int k;
        for (int i = 0; i < n; i += 2){
            k = i + 1;
            res[i] = k;
            res[i+1] = - k;
        }
        return res;
    }
}
