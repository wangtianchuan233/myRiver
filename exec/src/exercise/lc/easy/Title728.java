package exercise.lc.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtianchuan
 * 自除数是指可以被它包含的每一位数除尽的数。
 *
 * 例如，128 是一个自除数，因为128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 *
 * 还有，自除数不允许包含 0 。
 *
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 *
 * 示例 1：
 *
 * 输入： 
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 注意：
 *
 * 每个输入参数的边界满足1 <= left <= right <= 10000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title728 {
    public static void main(String[] args) {
        System.out.println(new Title728().m(1,22));
    }
    public List<Integer> m(int left, int right){
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (judge(i)){
                res.add(i);
            }
        }
        return res;
    }

    private boolean judge(int num) {
        int a = 0, b = num;
        while (b >= 10){
            a = b % 10;
            if (a == 0 || num % a != 0){
                return false;
            }
            b = b / 10;
        }
        return b != 0 && num % b == 0;
    }
}
