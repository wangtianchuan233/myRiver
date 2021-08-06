package exercise.lc.middle;

/**
 * @author wangtianchuan 2021/8/5
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * 0     6        12       18
 * 1   5 7     11 13    17
 * 2 4   8  10    14 16
 * 3     9        15
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title6 {
    public static void main(String[] args) {
        String s = "A";
        System.out.println(convert(s,2));
    }
    public static String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        StringBuilder ans = new StringBuilder();
        int T = (numRows << 1) - 2;
        for(int j = 0; j < s.length(); j += T){
            ans.append(s.charAt(j));
        }
        for (int i = 1; i < numRows - 1; i++){
            for(int j = i; j < s.length(); j += T) {
                ans.append(s.charAt(j));
                if (j + T - 2 * i < s.length()) {
                    ans.append(s.charAt(j + T - 2 * i));
                }
            }
        }
        for(int j = numRows - 1; j < s.length(); j += T){
            ans.append(s.charAt(j));
        }
        return ans.toString();
    }
}
