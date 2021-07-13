package exercise.lc.easy;

/**
 * @author wangtianchuan
 * <p>
 * 实现strStr()函数。
 * <p>
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 * <p>
 * 说明：
 * <p>
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title28 {

    /*
    年轻人不讲码德
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    /*
     * 前言
     * 本题是经典的字符串单模匹配的模型，因此可以使用字符串匹配算法解决，常见的字符串匹配算法包括暴力匹配、Knuth-Morris-Pratt 算法、Boyer-Moore 算法、Sunday 算法等，本文将讲解 Knuth-Morris-Pratt 算法。
     *
     * 因为哈希方法可能出现哈希值相等但是字符串不相等的情况，而 strStr 函数要求匹配结果必定正确，因此本文不介绍哈希方法，有兴趣的读者可以自行了解滚动哈希的实现（如 Rabin-KarpSunday 算法）。
     *
     * 方法一：暴力匹配
     * 思路及算法
     *
     * 我们可以让字符串 needle 与字符串 haystack 的所有长度为 mm 的子串均匹配一次。
     *
     * 为了减少不必要的匹配，我们每次匹配失败即立刻停止当前子串的匹配，对下一个子串继续匹配。
     * 如果当前子串匹配成功，我们返回当前子串的开始位置即可。如果所有子串都匹配失败，则返回 −1。
     */

    /*
     * 方法二：Knuth-Morris-Pratt 算法
     * TODO
     */
}
