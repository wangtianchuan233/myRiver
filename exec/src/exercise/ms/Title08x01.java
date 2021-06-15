package exercise.ms;

/**
 * @author wangtianchuan 2021/6/15
 *
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。
 * 结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 * 示例2:
 *
 *  输入：n = 5
 *  输出：13
 * 提示:
 *
 * n范围在[1, 1000000]之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title08x01 {
    // 39 ms
    public int waysToStep(int n) {
        int len = Math.max(n + 1, 4);
        int mod = 1000000007;
        int[] count = new int[len];
        count[1] = 1;
        count[2] = 2;
        count[3] = 4;
        if (n <= 3){
            return count[n];
        }
        for(int i = 4; i < len; i++){
            count[i] = ((count[i - 1] + count[i - 2]) % mod + count[i - 3]) % mod;
        }
        return count[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().waysToStep(61));
    }
}

// 0ms
class Solution {
    private long[][] matrix_mul(long[][] x, long y[][], int p) {
        long[][] a = new long[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    a[i][j] = ((x[i][k] * y[k][j]) % p + a[i][j]) % p;
                }
            }
        }
        return a;
    }

    private int quickpow(int n) {
        int p = 1000000007;
        long[][] ans = new long[3][3];
        ans[0][0] = ans[1][1] = ans[2][2] = 1;

        long[][] t = new long[3][3];
        t[0][0] = t[0][1] = t[1][0] = t[2][0] = t[1][2] = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = matrix_mul(ans, t, p);
            }
            t = matrix_mul(t, t, p);
            n >>= 1;
        }
        long res = (((2 * ans[0][0]) % p + ans[0][0]) % p + ans[0][0]) % p;          //防炸
        res = ((2 * ans[1][0]) % p + res) % p;
        res = ((ans[2][0]) % p + res) % p;
        return (int) res;
    }

    public int waysToStep(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        return quickpow(n - 3);
    }
}
