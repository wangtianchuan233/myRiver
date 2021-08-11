package util;

/**
 * @author wangtianchuan 2021/8/10
 * 一个存放了很多用于判断的工具方法的工具类, 其下的方法返回类型为 true 或者 false
 */
public class Judge {

    private Judge() {
    }

    /**
     * 判断 n 是不是素数
     *
     * @param n 整数 n, int 类型
     * @return true, 如果 n 是素数, 否则返回 false
     */
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
