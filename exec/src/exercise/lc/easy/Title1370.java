package exercise.lc.easy;

/**
 * @author wangtianchuan
 * 给你一个字符串s，请你根据下面的算法重新构造字符串：
 * 
 * 1 从 s中选出 最小的字符，将它 接在结果字符串的后面。
 * 2 从 s剩余字符中选出最小的字符，且该字符比上一个添加的字符大，将它 接在结果字符串后面。
 * 3 重复步骤 2 ，直到你没法从 s中选择字符。
 * 4 从 s中选出 最大的字符，将它 接在结果字符串的后面。
 * 5 从 s剩余字符中选出最大的字符，且该字符比上一个添加的字符小，将它 接在结果字符串后面。
 * 6 重复步骤 5，直到你没法从 s中选择字符。
 * 7 重复步骤 1 到 6 ，直到 s中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个，你可以选择其中任意一个，并将其添加到结果字符串。
 * 
 * 请你返回将s中字符重新排序后的 结果字符串 。
 * 
 * 示例 1：
 * 
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 * 示例 2：
 * 
 * 输入：s = "rat"
 * 输出："art"
 * 解释：单词 "rat" 在上述算法重排序以后变成 "art"
 *
 * 提示：
 *
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-decreasing-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title1370 {
    public static void main(String[] args) {
        String s = "rat";
        System.out.println(new Title1370().sortString(s));
    }

    public String sortString(String s) {
        if (s.length() < 2){
            return s;
        }
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 97]++;
        }
        char[] ans = new char[s.length()];
        int index = 0;
        while (index < ans.length){
            // 正向遍历 count 数组
            for(int i = 0; i < 26; i++){
                if (count[i] > 0){
                    ans[index++] = (char)(i + 97);
                    count[i]--;
                }
            }
            // 反向遍历 count 数组
            for(int i = 25; i >= 0; i--){
                if (count[i] > 0){
                    ans[index++] = (char)(i + 97);
                    count[i]--;
                }
            }
        }
        return new String(ans);
    }
}
