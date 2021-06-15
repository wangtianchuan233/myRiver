package exercise.lc.easy;

/**
 * @author wangtianchuan 2021/6/15
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Title70 {
    public static void main(String[] args) {
        System.out.println(new Title70().climbStairs(45));
    }
    public int climbStairs(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        if (n == 0) return res[0];
        res[1] = 1;
        if (n == 1) return res[1];
        res[2] = 2;
        for(int i = 3; i <= n; i++){
            res[i] = res[i -1] + res[i - 2];
        }
        return res[n];
    }
}
