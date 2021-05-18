package exercise.easy;

/**
 * @author wangtianchuan
 * 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title1047 {
    public static void main(String[] args) {
        String s = "bbabaaaaaa";
        System.out.println(new Title1047().removeDuplicates3(s));
    }

    // 仿写
    public String removeDuplicates3(String s) {
        char[] cs = s.toCharArray();
        char[] res = new char[s.length()];
        int index = 0;
        for (char c : cs) {
            if (index > 0 && res[index - 1] == c){
                index--;
            } else {
                res[index] = c;
                index++;
            }
        }
        return new String(res, 0 , index);
    }

    /*
        作者：AC_OIer
        链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/solution/cong-30-dao-100wu-chong-shi-xian-jie-jue-vkah/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public String removeDuplicates2(String s) {
        char[] cs = s.toCharArray();
        char[] d = new char[s.length()];
        int hh = 0, tt = -1;
        for (char c : cs) {
            if (hh <= tt && d[tt] == c) {
                tt--;
            } else {
                d[++tt] = c;
            }
        }
        return new String(d, 0, tt + 1);
    }

    /*
        时间:5.76%, 空间83%
     */
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = 1;
        final int len = chars.length;
        int[] indexes = null;
        while ((indexes = hasDuplicates(chars))[0] > -1) {
            chars[indexes[0]] = 96;
            chars[indexes[1]] = 96;
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < len; k++){
            if (chars[k] > 96){
                sb.append(chars[k]);
            }
        }
        return sb.toString();
    }

    public int[] hasDuplicates(char[] chars) {
        int i = 0, j = 1;
        final int len = chars.length;
        while (j < len) {
            while (j < len && chars[i] == 96){
                i++;
                j++;
            }
            if (j >= len){
                break;
            }
            while (j < len && chars[j] == 96){
                j++;
            }

            if (j >= len){
                break;
            }

            if (chars[i] == chars[j]) {
                return new int[]{i,j};
            }
            i += (j - i);
            j++;
        }
        return new int[]{-1,-1};
    }
}
