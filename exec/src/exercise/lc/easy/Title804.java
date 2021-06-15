package exercise.lc.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangtianchuan
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串，比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
 *
 * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
 *
 * [
 * ".-",
 * "-...",
 * "-.-.",
 * "-..",
 * ".",
 * "..-.",
 * "--.",
 * "....",
 * "..",
 * ".---",
 * "-.-",
 * ".-..",
 * "--",
 * "-.",
 * "---",
 * ".--.",
 * "--.-",
 * ".-.",
 * "...",
 * "-",
 * "..-",
 * "...-",
 * ".--",
 * "-..-",
 * "-.--",
 * "--.."]
 *
 * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，
 * (即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作单词翻译。
 *
 * 返回我们可以获得所有词不同单词翻译的数量。
 *
 * 例如:
 * 输入: words = ["gin", "zen", "gig", "msg"]
 * 输出: 2
 * 解释: 
 * 各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 *
 * 共有 2 种不同翻译, "--...-." 和 "--...--.".
 *
 * 注意:
 *
 * 单词列表words的长度不会超过 100。
 * 每个单词words[i]的长度范围为[1, 12]。
 * 每个单词words[i]只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-morse-code-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title804 {

    public static void main(String[] args) {
        /*
         * 拼串测试, 使用 String 拼接
         *
         * len      String耗时(ms)   StringBuilder耗时(ms)
         * 100          0                   0
         * 1000         2                   0
         * 10000        169                 1
         * 100000       14742               4
         *
         */
        int len = 10000;
        String x = "";
        StringBuilder y = new StringBuilder();
        final long t1 = System.currentTimeMillis();

        // 使用 String 拼接
        for (int i = 0; i < len; i++) {
            x += i;
        }

        final long t2 = System.currentTimeMillis();

        // 使用 StringBuilder 拼接
        /*for (int i = 0; i < len; i++) {
            y.append(i);
        }*/

        final long t3 = System.currentTimeMillis();

        System.out.println("使用 String 拼接" + (t2 - t1));
        System.out.println("使用 StringBuilder 拼接" + (t3 - t2));
    }

    /*
     4ms, 23.4%
     */
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> codeSet = new HashSet<>();
        for (String word : words) {
            final char[] letters = word.toCharArray();
            String code = "";
            for (char letter : letters) {
                code += morseCode[letter - 97];
            }
            codeSet.add(code);
        }
        return codeSet.size();
    }

    /*
      把上面String类的拼接换成StringBuilder的拼接:
      2 ms, 99.31%
     */
    public int uniqueMorseRepresentations2(String[] words) {
        String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> codeSet = new HashSet<>();
        for (String word : words) {
            final char[] letters = word.toCharArray();
            StringBuilder code = new StringBuilder();
            for (char letter : letters) {
                code.append(morseCode[letter - 97]);
            }
            codeSet.add(code.toString());
        }
        return codeSet.size();
    }

}
