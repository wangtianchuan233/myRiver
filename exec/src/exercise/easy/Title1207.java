package exercise.easy;

import java.util.Arrays;

/**
 * @author wangtianchuan
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 * 示例 1：
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 *
 * 示例 2：
 * 输入：arr = [1,2]
 * 输出：false
 *
 * 示例 3：
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *
 * 提示：
 *
 * 1 <= arr.length<= 1000
 * -1000 <= arr[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-number-of-occurrences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title1207 {
    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.println(new Title1207().uniqueOccurrences(arr));
    }
    /*
        时间 97%, 内存 12%
     */
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] + 1000]++;
        }
        int[] countForCount = new int[arr.length];
        for (int i = 0; i < count.length; i++){
            if (count[i] == 0) continue;
            if (++countForCount[count[i]] > 1){
                return false;
            }
        }
        return true;
    }

    /*
        作者：yi-mei-xue-zha
        链接：https://leetcode-cn.com/problems/unique-number-of-occurrences/solution/javashuang-bai-by-yi-mei-xue-zha-xu2t/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean uniqueOccurrences2(int[] arr) {
        //判断特殊情况，如果只有一个数直接返回true，如果有两个数且两个不相等返回false，如果两个数相等返回true
        if (arr.length <= 1) {
            return true;
        }
        if (arr.length == 2) {
            if (arr[0] == arr[1]) {
                return true;
            } else {
                return false;
            }
        }
        //创建一个数组来保存所给数组中每个元素出现的次数
        int[] res = new int[arr.length];
        int n = 0;//不同元素的个数
        res[0]++;
        //将所给数组进行排序，便于判断每个元素出现的次数
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                res[n]++;
            } else {
                n++;
                res[n]++;
            }
        }
        //将所得到的不同元素的个数进行排序
        Arrays.sort(res);
        //遍历数组如果有两个数相同则返回false
        for (int i = res.length - 1; i > res.length - n; i--) {
            if (res[i] == res[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
