package exercise.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangtianchuan
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * <p>
 * 示例 2：
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title1002 {
    public static void main(String[] args) {
        String[] words = {"bella","label","roller"};
        System.out.println(new Title1002().commonChars2(words));
    }

    /*
        8ms 40.4%
     */
    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        final int len = words.length;
        int[][] counter = null;
        for (int i = 0; i < len; i++) {
            counter = new int[len][26];
        }
        for (int i = 0; i < words.length; i++) {
            final char[] chars = words[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                counter[i][chars[j] - 97]++;
            }
        }
        for (int j = 0; j < 26; j++) {
            boolean flag = true;
            while (flag && --counter[0][j] >= 0) {
                for (int i = 1; i < counter.length; i++){
                    if (--counter[i][j] < 0){
                        flag = false;
                        break;
                    }
                }
                if (flag)
                res.add(Character.toString((char) (j + 97)));
            }
        }
        return res;
    }

    /*
        3ms, 98.58%
     */
    public List<String> commonChars2(String[] words) {
        List<String> res = new ArrayList<>();
        int[] counter = new int[26];
        int[] minNum = new int[26];
        Arrays.fill(minNum, 1001);
        for (int i = 0; i < words.length; i++) {
            // 把单词 words[i] 转为 char数组
            final char[] chars = words[i].toCharArray();
            // 统计单词 words[i] 中每个字母出现的次数
            Arrays.fill(counter, 0);
            for (int j = 0; j < chars.length; j++) {
                counter[chars[j] - 97]++;
            }
            // 在 minNum 中储存字母出现的最少次数
            for (int j = 0; j < 26; j++){
                minNum[j] = Math.min(minNum[j], counter[j]);
            }
        }
        // 遍历 minNum 添加元素到结果中
        for (int j = 0; j < 26; j++){
            while (minNum[j]-- > 0){
                res.add(Character.toString((char) (j + 97)));
            }
        }
        return res;
    }
}
