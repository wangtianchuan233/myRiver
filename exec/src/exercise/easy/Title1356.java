package exercise.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wangtianchuan
 * 给你一个整数数组arr。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 * 示例 4：
 * 输入：arr = [2,3,5,7,11,13,17,19]
 * 输出：[2,3,5,17,7,11,13,19]
 *
 * 示例 5：
 * 输入：arr = [10,100,1000,10000]
 * 输出：[10,100,10000,1000]
 *
 *
 * 提示：
 *      1 <= arr.length <= 500
 *      0 <= arr[i] <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title1356 {

    public static void main(String[] args) {
        int[] arr = {2,3,5,7,11,13,17,19};
        System.out.println(Arrays.toString(new Title1356().sortByBits2(arr)));
    }

    /*
    执行用时：9 ms, 在所有 Java 提交中击败了60.27%的用户
    内存消耗：38.6 MB, 在所有 Java 提交中击败了80.92%的用户
     */
    public int[] sortByBits(int[] arr) {
        final int len = arr.length;
        List<Integer> [] count = new ArrayList[15];
        for (int i = 0; i < 15; i++) {
            count[i] = new ArrayList<>();
        }
        for (int i = 0; i < len; i++){
            count[Integer.bitCount(arr[i])].add(arr[i]);
        }
        int[] res = new int[len];
        int k = 0;
        for (List<Integer> c : count) {
            Collections.sort(c);
            for (Integer num : c) {
                res[k++] = num;
            }
        }
        return res;
    }

    /*
        作者：yourtion
        链接：https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/solution/javaliang-ci-xun-huan-da-bai-100-by-yourtion/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        3ms, 99.76%
     */
    public int [] sortByBits2(int[] arr){
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = Integer.bitCount(arr[i]) * 100000 + arr[i];
        }
        Arrays.sort(res);
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] % 100000;
        }
        return res;
    }
}
