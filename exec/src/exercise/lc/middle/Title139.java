package exercise.lc.middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wangtianchuan 2021/8/20
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *     注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Title139 {
    public static void main(String[] args) {
        Title139 t = new Title139();
        String s  = "applepenapple";
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        System.out.println(t.wordBreak(s, list));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int maxLength = 0;
        for (String x : wordDict) {
            maxLength = Math.max(maxLength, x.length());
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 0; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                int aa = i;
                int bb = j;
                boolean cc = dp[j];
                String dd = s.substring(j, i);
                if (!dp[j] || i - j > maxLength){
                    continue;
                }
                if (dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
