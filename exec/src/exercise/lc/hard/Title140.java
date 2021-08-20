package exercise.lc.hard;

import java.util.*;

/**
 * @author wangtianchuan 2021/8/20
 * 
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。
 * 返回所有这些可能的句子。
 *
 * 说明：
 * 分隔时可以重复使用字典中的单词。你可以假设字典中没有重复的单词。
 *
 * 示例 1：
 * 输入: s = "catsanddog", wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出: ["cats and dog", "cat sand dog"]
 *
 * 示例 2：
 * 输入: s = "pineapplepenapple", wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出: ["pine apple pen apple", "pineapple pen apple", "pine applepen apple"]
 * 解释: 注意你可以重复使用字典中的单词。
 *
 * 示例3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: []
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title140 {
    public static void main(String[] args) {
        Title140 t = new Title140();
        String s  = "aaaaaaa";
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aa");
        list.add("a");
        List<String> ans = t.wordBreak(s, list);
//        ans.sort(Comparator.comparingInt(String::length));
        for (String s1 : ans) {
            System.out.println(s1);
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> combined = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordDict);
        List<String> ans = new ArrayList<>();
        dfs(s, dict, ans, combined, 0);
        return ans;
    }

    private void dfs(String s, Set<String> wordDict, List<String> ans, List<String> combined, int offset) {
        if (offset == s.length()){
            ans.add(transform(combined));
            return;
        }
        for(int i = offset + 1; i <= s.length(); i++){
            String part = s.substring(offset, i);
            if (wordDict.contains(part)){
                combined.add(part);
                dfs(s, wordDict, ans, combined, i);
                combined.remove(combined.size() - 1);
            }
        }
    }

    private String transform(List<String> combined) {
        StringBuilder sb = new StringBuilder();
        if (combined.size() > 0){
            combined.forEach(x -> {
                sb.append(x);
                sb.append(' ');
            });
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
