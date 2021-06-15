package exercise.lc.easy;

/**
 * @author wangtianchuan
 * 给你一个仅由数字 6 和 9 组成的正整数num。
 *
 * 你最多只能翻转一位数字，将 6 变成9，或者把9 变成6 。
 *
 * 请返回你可以得到的最大数字。
 *
 * 示例 1：
 * 输入：num = 9669
 * 输出：9969
 *
 * 示例 2：
 * 输入：num = 9996
 * 输出：9999
 * 解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
 *
 * 示例 3：
 * 输入：num = 9999
 * 输出：9999
 * 解释：无需改变就已经是最大的数字了。
 *
 * 提示：
 *
 * 1 <= num <= 10^4
 * num每一位上的数字都是 6 或者9 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-69-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title1323 {
    public static void main(String[] args) {
        System.out.println(new Title1323().m(999));
    }

    public int m(int num){
        int a = 0;
        int count = 0;
        int b = num;
        int c;
        while (b > 0){
            c = b % 10;
            b = b / 10;
            count ++;
            if (c == 6) {
                a = count;
            }
        }
        c = a > 0 ? 3 : 0;
        for (int i = 0; i < a - 1; i++) {
            c = 10 * c;
        }
        return num + c;
    }
}
