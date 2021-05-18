package exercise.easy;

/**
 * @author wangtianchuan
 * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 *
 * 示例：
 *
 * 输入： a = 1, b = 2
 * 输出： 2
 */
public class TitleMs16x07 {
    public static void main(String[] args) {
        int a = 2;
        int b = 5;
        System.out.println(new TitleMs16x07().maximum(a,b));
    }
    public int maximum(int a, int b) {
        // 两个int做运算可能会超出范围, 转为long类型
        long c = a, d = b;
        // 二进制数最左端的数字为符号位:0代表正,1代表负。
        // a - b 右移 63 位,
        // 如果 a-b 为正, 则(c - d) >> 63为 0, 说明 a > b, 此时k = 1, j = 0;
        // 如果 a-b 为负, 则(c - d) >> 63为 1, 说明 a < b, 此时k = 0, j = 1;
        int k = 1 + (int)((c - d) >> 63);
        int j = 1 ^ k;
        return k * a + j * b;
    }
}
