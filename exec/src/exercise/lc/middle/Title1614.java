package exercise.lc.middle;

/**
 * @author wangtianchuan
 * 
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 *
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：5
 *
 * 解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
 *
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：15
 * 解释：仅由元音组成的 15 个字典序字符串为
 *
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
 * 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
 *
 * 示例 3：
 *
 * 输入：n = 33
 * 输出：66045
 *
 * 提示：
 *
 * 1 <= n <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-sorted-vowel-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * [1, 1, 1, 1, 1]
 * [5, 4, 3, 2, 1]
 * [15 10 6, 3, 1]
 * [35 20 10 4  1]
 */
public class Title1614 {
    public static void main(String[] args) {
        System.out.println(countVowelStrings2(2));
    }

    //  时间复杂度 O(n), 空间复杂度, O(n)
    public static int countVowelStrings(int n) {
        int[][] count = new int[n][5];
        for(int j = 0; j < 5; j++){
            count[0][j] = 1;
        }
        for(int i = 1; i < n; i++){
            count[i][4] = 1;
            for(int j = 3; j >= 0; j--){
                count[i][j] = count[i][j + 1] + count[i - 1][j];
            }
        }
        int sum = 0;
        for(int x : count[n - 1]){
            sum += x;
        }
        return sum;
    }
    // 优化空间复杂度, 时间复杂度 O(n), 空间复杂度 O(1)
    public static int countVowelStrings2(int n) {
        int[] count = new int[]{1,1,1,1,1};
        for(int i = 1; i < n; i++){
            for(int j = 3; j >= 0; j--){
                count[j] = count[j] + count[j + 1];
            }
        }
        int sum = 0;
        for(int x : count){
            sum += x;
        }
        return sum;
    }
}
