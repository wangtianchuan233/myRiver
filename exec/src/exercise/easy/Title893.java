package exercise.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wangtianchuan
 * 你将得到一个字符串数组 A。
 *
 * 每次移动都可以交换 S 的任意两个偶数下标的字符或任意两个奇数下标的字符。
 *
 * 如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是 特殊等价 的。
 *
 * 例如，S = "zzxy" 和 T = "xyzz" 是一对特殊等价字符串，因为可以先交换 S[0] 和 S[2]，
 * 然后交换 S[1] 和 S[3]，使得 "zzxy" -> "xzzy" -> "xyzz" 。
 *
 * 现在规定，A 的 一组特殊等价字符串 就是 A 的一个同时满足下述条件的非空子集：
 *
 * 该组中的每一对字符串都是 特殊等价 的
 * 该组字符串已经涵盖了该类别中的所有特殊等价字符串，容量达到理论上的最大值
 * （也就是说，如果一个字符串不在该组中，那么这个字符串就 不会 与该组内任何字符串特殊等价）
 * 返回 A中特殊等价字符串组的数量。
 *
 * 示例 1：
 *
 * 输入：["abcd","cdab","cbad","xyzz","zzxy","zzyx"]
 * 输出：3
 * 解释：
 * 其中一组为 ["abcd", "cdab", "cbad"]，因为它们是成对的特殊等价字符串，且没有其他字符串与这些字符串特殊等价。
 * 另外两组分别是 ["xyzz", "zzxy"] 和 ["zzyx"]。特别需要注意的是，"zzxy" 不与 "zzyx" 特殊等价。
 *
 * 示例 2：
 *
 * 输入：["abc","acb","bac","bca","cab","cba"]
 * 输出：3
 * 解释：3 组 ["abc","cba"]，["acb","bca"]，["bac","cab"]
 * 
 *
 * 提示：
 *
 * 1 <= A.length <= 1000
 * 1 <= A[i].length <= 20
 * 所有A[i]都具有相同的长度。
 * 所有A[i]都只由小写字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/groups-of-special-equivalent-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title893 {

    public static void main(String[] args) {

    }

    /*
     16ms, 48%
     */
    public int numSpecialEquivGroups(String[] words) {
        Set<String> set = new HashSet<>();
        for (String s : words) {
            int[] v = new int[52];
            for (int i = 0; i < s.length(); i++){
                v[(s.charAt(i) - 97) + (i % 2) * 26]++;
            }
            set.add(Arrays.toString(v));
        }
        return set.size();
    }

    /**
     * 官方, 耗时0ms答案
     */

    // 保存前 26 个质数，PRIMES[i] 记录字符 i + 'a' 对应的质数。
    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    public int numSpecialEquivGroups2(String[] words) {
        HashMap<Long, Object> wordSet = new HashMap<>();
        int n = words[0].length();
        for (String word : words) {
            wordSet.put(hashCode(word, n), null);
        }
        return wordSet.size();
    }

    private long hashCode(String word, int n) {
        char[] str = word.toCharArray();
        long hashCode1 = 1, hashCode2 = 1;
        for (int i = 0; i < n; i += 2) {
            hashCode1 *= PRIMES[str[i] - 'a'];
        }
        for (int i = 1; i < n; i += 2) {
            hashCode2 *= PRIMES[str[i] - 'a'];
        }
        return hashCode1 << 16 | hashCode2;
    }

}
