package exercise.lc.easy;

/**
 * @author wangtianchuan
 * 
 * 有效括号字符串为空("")、"(" + A + ")"或A + B，其中A 和B都是有效的括号字符串，+代表字符串的连接。
 * 例如，""，"()"，"(())()"和"(()(()))"都是有效的括号字符串。
 * 如果有效字符串S非空，且不存在将其拆分为S = A+B的方法，我们称其为原语（primitive），其中A 和B都是非空有效括号字符串。
 * 给出一个非空有效字符串S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中P_i是有效括号字符串原语。
 * 对S进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S。
 *
 * 示例 1：
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 *
 * 示例 2：
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 *
 * 示例 3：
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 *
 * 提示：
 *
 * S.length <= 10000
 * S[i] 为"(" 或")"
 * S 是一个有效括号字符串
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-outermost-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title1021 {
    public static void main(String[] args) {
        System.out.println(new Title1021().removeOuterParentheses("(()())(())"));
    }
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int x = 0, y = 0, len = s.length();
        char c;
        for (int i = 0; i < len; i++) {
            c = s.charAt(i);
            if ('(' == c){
                x++;
                if(x > 1) {
                    sb.append(c);
                }
            } else {
                x--;
                if (x != 0){
                    sb.append(c);
                }
            }

        }
        return  sb.toString();
    }
}
