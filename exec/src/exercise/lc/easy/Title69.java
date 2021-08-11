package exercise.lc.easy;

/**
 * @author wangtianchuan
 * 实现int sqrt(int x)函数。
 * <p>
 * 计算并返回x的平方根，其中x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title69 {
    public static void main(String[] args) {
        final Title69 t = new Title69();
        System.out.println(46340 * 46340);
//        System.out.println(t.sqrt(2147483647));
    }

    public int sqrt(int x) {
        if (x > 2147395599){
            return 46340;
        } else if (x < 17) {
            return enumSqrt(x);
        } else if (x < 92680) {
            return binaryFindSqrt(x, 5, x / 2);
        } else {
            return binaryFindSqrt(x, 5, 46340);
        }
    }

    private int binaryFindSqrt(int x, int l, int r) {
        int mid = (l + r) / 2;
        final int mid2 = mid * mid;
        if (mid2 == x) {
            return mid;
        }
        if (mid2 > x) {
            return binaryFindSqrt(x, l, mid - 1);
        }
        final int next2 = (mid + 1) * (mid + 1);
        if (next2 == x) {
            return mid + 1;
        }
        if (next2 < x) {
            return binaryFindSqrt(x, mid + 2, r);
        }
        // 执行到这里说明 mid ^ 2 <= x 且 (mid + 1) ^ 2 >= x
        return mid;
    }

    private int enumSqrt(int x) {
        int ans = 4;
        while (ans * ans > x) {
            ans--;
        }
        return ans;
    }
}