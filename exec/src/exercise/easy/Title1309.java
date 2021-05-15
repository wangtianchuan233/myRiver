package exercise.easy;

/**
 * @author wangtianchuan
 * 给你一个字符串s，它由数字（'0' - '9'）和'#'组成。我们希望按下述规则将s映射为一些小写英文字符：
 * <p>
 * 字符（'a' - 'i'）分别用（'1' -'9'）表示。
 * 字符（'j' - 'z'）分别用（'10#'-'26#'）表示。
 * 返回映射之后形成的新字符串。
 * <p>
 * 题目数据保证映射始终唯一。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "10#11#12"
 * 输出："jkab"
 * 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * 示例 2：
 * <p>
 * 输入：s = "1326#"
 * 输出："acz"
 * 示例 3：
 * <p>
 * 输入：s = "25#"
 * 输出："y"
 * 示例 4：
 * <p>
 * 输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * 输出："abcdefghijklmnopqrstuvwxyz"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title1309 {
    public static void main(String[] args) {
        String s = "10#11#12";
        System.out.println(new Title1309().m(s));
    }

    public String m(String s) {
        int index = 0;
        StringBuilder res = new StringBuilder();
        while (index < s.length()) {
            if (s.length() - index < 3 || '#' != s.charAt(index + 2)) {
                res.append(mapNumToLetter(s.substring(index, index + 1)));
                index += 1;
            } else {
                res.append(mapNumToLetter(s.substring(index, index + 2)));
                index += 3;
            }
        }
        return res.toString();
    }

    public char mapNumToLetter(String str) {
        return mapNumToLetter(Integer.parseInt(str));
    }

    public char mapNumToLetter(int num) {
        return (char) (num + 96);
    }
}
