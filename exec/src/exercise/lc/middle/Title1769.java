package exercise.lc.middle;

import java.util.Arrays;

/**
 * @author wangtianchuan
 * 
 * 有 n 个盒子。给你一个长度为 n 的二进制字符串 boxes ，其中 boxes[i] 的值为 '0' 表示第 i 个盒子是 空 的，而 boxes[i] 的值为 '1' 表示盒子里有 一个 小球。
 *
 * 在一步操作中，你可以将 一个 小球从某个盒子移动到一个与之相邻的盒子中。第 i 个盒子和第 j 个盒子相邻需满足 abs(i - j) == 1 。注意，操作执行后，某些盒子中可能会存在不止一个小球。
 *
 * 返回一个长度为 n 的数组 answer ，其中 answer[i] 是将所有小球移动到第 i 个盒子所需的 最小 操作数。
 *
 * 每个 answer[i] 都需要根据盒子的 初始状态 进行计算。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：boxes = "110"
 * 输出：[1,1,3]
 * 解释：每个盒子对应的最小操作数如下：
 * 1) 第 1 个盒子：将一个小球从第 2 个盒子移动到第 1 个盒子，需要 1 步操作。
 * 2) 第 2 个盒子：将一个小球从第 1 个盒子移动到第 2 个盒子，需要 1 步操作。
 * 3) 第 3 个盒子：将一个小球从第 1 个盒子移动到第 3 个盒子，需要 2 步操作。将一个小球从第 2 个盒子移动到第 3 个盒子，需要 1 步操作。共计 3 步操作。
 * 示例 2：
 *
 * 输入：boxes = "001011"
 * 输出：[11,8,5,4,3,4]
 * 
 *
 * 提示：
 *
 * n == boxes.length
 * 1 <= n <= 2000
 * boxes[i] 为 '0' 或 '1'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title1769 {

    // 146 ms

    public int[] minOperations(String boxes) {
        char[] arr = boxes.toCharArray();
        int[] res = new int[arr.length];
        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < res.length; j++){
                if (arr[j] == '1'){
                    res[i] += Math.abs(j - i);
                }
            }
        }
        return res;
    }
    public int[] minOperations2(String boxes) {

        final char[] arr = boxes.toCharArray();
        int[] res = new int[arr.length];
        int left = 0, right = 0;

        for(int j = 1; j < arr.length; j++){
            if (arr[j] == '1'){
                res[0] += j;
                right++;
            }
        }

        for(int i = 1; i < arr.length; i++){
            if (arr[i] == '1'){
                right--;
                res[i]--;
            }
            res[i] += res[i - 1] + left - right;
            if (arr[i - 1] == '1'){
                left++;
                res[i]++;
            }
        }
        return res;
    }
    /*
     i  left(i)  right(i)  sum(i)  res(i) res(i - 1)
     0  0           1       1       1       0
     1  1           0       1       1       1
     2  2           0       3       0       1
     */

    public static void main(String[] args) {
        final int[] ints = new Title1769().minOperations2("110");
        System.out.println(Arrays.toString(ints));
    }
}
