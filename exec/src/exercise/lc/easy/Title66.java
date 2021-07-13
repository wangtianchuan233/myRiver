package exercise.lc.easy;

import java.util.Arrays;

/**
 * @author wangtianchuan
 * 
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 
 *
 * 示例1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title66 {
    public static void main(String[] args) {
        int [] nums = {9,9,9};
        System.out.println(Arrays.toString(plusOne(nums)));
    }
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        return plusOne(digits, len - 1, len);
    }
    public static int[] plusOne(int[] nums, int index, int len){
        if(nums[index] < 9){
            nums[index]++;
            return nums;
        }
        if(index == 0){
            int[] res = new int[len + 1];
            res[0] = 1;
            return res;
        }
        nums[index] = 0;
        return plusOne(nums, index - 1, len);
    }
}
