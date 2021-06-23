package exercise.lc.middle;

/**
 * @author wangtianchuan 2021/6/23
 *
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title62 {
    public static void main(String[] args) {
        testFactorial(22);
    }

    /**
     * 经测试, 13! 超过 int 上限, 21! 超过 long 上限
     * @param n
     */
    public static void testFactorial(int n){
        long[] a = new long[n + 1];
        a[0] = 1;
        a[1] = 1;
        for(int i = 2; i <= n; i++){
            a[i] = a[i - 1] * i;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println("第" + i + "个:\t" + a[i]);
        }
    }

    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1){
            return 1;
        }
        int a = m + n - 2;
        return (int)g(m + n - 2, n - 1);
    }
    public long g(long m, long n){
        n = Math.min(n, m - n);
        return f(m, m - n + 1) / f(n, 1);
    }
    public long f(long a, long b){
        if(a == b){
            return b;
        } else {
            return a * f(a - 1, b);
        }
    }
}
