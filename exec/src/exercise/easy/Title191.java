package exercise.easy;

/**
 * @author wangtianchuan
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 *
 * 提示：
 *
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的示例 3中，输入表示有符号整数 -3。
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。
 * 示例 2：
 *
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000中，共有一位为 '1'。
 * 示例 3：
 *
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *
 * 提示：
 *
 * 输入必须是长度为 32 的 二进制串 。
 * 
 *
 * 进阶：
 *
 * 如果多次调用这个函数，你将如何优化你的算法？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-1-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Title191 {
    public static void main(String[] args) {
        final Title191 t = new Title191();
        for (int i = -5; i <= 5; i++) {
            System.out.print(t.hammingWeigh3(i) + " =? ");
            System.out.println(t.hammingWeigh4(i));
        }
    }
    // you need to treat n as an unsigned value
    /*
     超时, 如果n为负数, -1 >> 1 还是 -1, 造成死循环
     */
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0){
            sum += (n & 1);
            n = n >> 1;
        }
        return sum;
    }

    /*
     在上面的基础上进行调整, 答案错误,
        Java二进制7: 111
        Java二进制-7: 11111111111111111111111111111001
        直接取绝对值的结果不行;
     */
    public int hammingWeight2(int n) {
        n = Math.abs(n);
        int sum = 0;
        while (n != 0){
            sum += (n & 1);
            n = n >> 1;
        }
        return sum;
    }

    /*
      官方答案, 固定循环32次;
     */
    public int hammingWeigh3(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
    public int hammingWeigh4(int n) {
        int sum = 0;
        for (int i = 0; i < 32; i++){
            // 经测试, 这里要用 != , 使用 > 号不能得出 n 为负数时的正确答案
            if ((n & (1 << i)) > 0){
                sum++;
            }
        }
        return sum;
    }




}
