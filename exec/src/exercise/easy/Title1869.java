package exercise.easy;

/**
 * @author wangtianchuan
 * 
 * 给你一个二进制字符串 s 。如果字符串中由 1 组成的 最长 连续子字符串 严格长于 由 0 组成的 最长 连续子字符串，返回 true ；否则，返回 false 。
 *
 * 例如，s = "110100010" 中，由 1 组成的最长连续子字符串的长度是 2 ，由 0 组成的最长连续子字符串的长度是 3 。
 * 注意，如果字符串中不存在 0 ，此时认为由 0 组成的最长连续子字符串的长度是 0 。字符串中不存在 1 的情况也适用此规则。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：s = "1101"
 * 输出：true
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 2："1101"
 * 由 0 组成的最长连续子字符串的长度是 1："1101"
 * 由 1 组成的子字符串更长，故返回 true 。
 * 示例 2：
 *
 * 输入：s = "111000"
 * 输出：false
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 3："111000"
 * 由 0 组成的最长连续子字符串的长度是 3："111000"
 * 由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
 * 示例 3：
 *
 * 输入：s = "110100010"
 * 输出：false
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 2："110100010"
 * 由 0 组成的最长连续子字符串的长度是 3："110100010"
 * 由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
 * 
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * s[i] 不是 '0' 就是 '1'
 * 通过次数8,600提交次数8,589
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longer-contiguous-segments-of-ones-than-zeros
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title1869 {
    public static void main(String[] args) {
        System.out.println(new Title1869().checkZeroOnes("1101"));
    }
    public boolean checkZeroOnes(String s) {
        int[] count = new int[2];
        int a = 0;
        int len = s.length();
        char cur = s.charAt(0);
        a = 1;
        count[cur - 48]++;
        for(int i = 1; i < len; i++){
            char c = s.charAt(i);
            if (cur == c){
                a++;
            } else {
                cur = c;
                a = 1;
            }
            count[cur - 48] = Math.max(count[cur - 48], a);
        }
        return count[1] > count[0];
    }
}
