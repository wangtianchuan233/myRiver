package exercise.lc.middle;

/**
 * @author wangtianchuan 2021/6/23
 * 
 * 给定三个字符串s1、s2、s3，请你帮忙验证s3是否是由s1和s2 交错 组成的。
 *
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 提示：a + b 意味着字符串 a 和 b 连接。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interleaving-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title97 {
    /*
        我们定义 f(i,j) 表示 s1 的前 i 个元素和 s2 的前 j 个元素是否能交错组成 s3 的前 i+j 个元素。

          如果 s1 的第 i   个元素和 s3 的第 i+j 个元素相等，
          那么 s1 的前 i   个元素和 s2 的前 j   个元素是否能交错组成 s3 的前 i+j 个元素
        取决于 s1 的前 i−1 个元素和 s2 的前 j   个元素是否能交错组成 s3 的前 i+j−1 个元素，
        即此时 f(i,j) 取决于 f(i−1,j)，在此情况下如果 f(i−1,j) 为真，则 f(i,j) 也为真。

        同样的，如果 s2 的第 j 个元素和 s3 的第i+j个元素相等并且f(i,j−1) 为真，则 f(i,j) 也为真。于是我们可以推导出这样的动态规划转移方程：

        f(i,j)=[f(i−1,j) && s1(i−1)=s3(p)] || [f(i,j−1) && s2(j−1) = s3(p)]

        其中 p = i+j−1。边界条件为 f(0,0)=True。至此，我们很容易可以给出这样一个实现：

        作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/interleaving-string/solution/jiao-cuo-zi-fu-chuan-by-leetcode-solution/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public static boolean isInterleave(String s1, String s2, String s3){
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()){
            return false;
        }
        boolean[][] b = new boolean[m + 1][n + 1];
        b[0][0] = true;
        for(int j = 1; j < n + 1; j++){
            b[0][j] = b[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for(int i = 1; i < m + 1; i++){
            b[i][0] = b[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                b[i][j] = (b[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) || (b[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }
        return b[m][n];
    }
    /**
     * 滚动数组优化空间复杂度
     */
    public static boolean isInterleave4(String s1, String s2, String s3){
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()){
            return false;
        }
        boolean[] b = new boolean[n + 1];
        b[0] = true;
        for(int j = 1; j < n + 1; j++){
            b[j] = b[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                b[j] = (b[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) || (b[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }
        return b[n];
    }
    /**
     * 超出时间限制
     */
    public static boolean isInterleave2(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3){
            return false;
        }
        return isInterleave2(s1, s2, s3, 0, 0, 0, len1, len2, len3);
    }
    public static boolean isInterleave2(String s1, String s2, String s3, int l1, int l2, int l3, int r1, int r2, int r3){

        boolean res = true;
        while (l3 < r3){
            char c1 = l1 < r1 ? s1.charAt(l1) : ' ';
            char c2 = l2 < r2 ? s2.charAt(l2) : ' ';
            char c3 = s3.charAt(l3);
            if (c3 == c1){
                if (c3 == c2){
                    res = isInterleave2(s1, s2, s3, l1 + 1, l2, l3 + 1, r1, r2, r3) || isInterleave2(s1, s2, s3, l1, l2 + 1, l3 + 1, r1, r2, r3);
                    break;
                } else {
                    l1++;
                    l3++;
                }
            } else {
                if (c3 == c2){
                    l2++;
                    l3++;
                } else {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }
}
