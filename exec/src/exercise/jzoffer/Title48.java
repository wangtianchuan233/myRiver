package exercise.jzoffer;

/**
 * @author wangtianchuan 2021/6/22
 * 
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title48 {
    private int[] d = new int[128];
    public int m(String s){
        if (s.length() <= 1){
            return s.length();
        }
        d[s.charAt(0)]++;
        int l = 0, max = 1;
        for(int r = 1; r < s.length(); r++){
            int index = s.charAt(r);
            d[index]++;

            while(d[index] > 1) {
                d[s.charAt(l)]--;
                l++;
            }

            max = Math.max(max, r - l + 1);
        }
        return max;
    }

}
