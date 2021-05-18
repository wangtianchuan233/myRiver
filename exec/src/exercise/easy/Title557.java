package exercise.easy;

/**
 * @author wangtianchuan
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title557 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        //String s = "contest";
        System.out.println(new Title557().reverseWords2(s));
    }

    /*
    双指针
     */
    public String reverseWords2(String s) {
        final int len = s.length();
        if (len == 0) return "";
        if (len == 1) return s;
        final char[] chars = s.toCharArray();
        int i = 0, j = 0;
        char temp;
        while (j < len){
            while (chars[j] != ' '){
                if (++j >= len) {
                    break;
                }
            }
            j--;
            for(int k = 0; k < (j - i + 1) / 2; k++) {
                temp = chars[i + k];
                chars[i + k] = chars[j - k];
                chars[j - k] = temp;
            }
            i = j + 2;
            j = i + 1;
        }
        return new String(chars);
    }


    public String reverseWords(String s) {
        final String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(reverseWord(words[i]) + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String reverseWord(String word) {
        final char[] chars = word.toCharArray();
        char temp = 0;
        for (int i = 0; i < chars.length / 2; i++) {
            temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return new String(chars);
    }
}
