package exercise.lc.easy;

/**
 * @author wangtianchuan
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title709 {
    public static void main(String[] args) {
        System.out.println(toLowerCase("AAABC"));
    }
    public static String toLowerCase(String str){
        final char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 64 && chars[i] < 91){
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return new String(chars);
    }
}
