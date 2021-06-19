package exercise.lc.middle;

/**
 * @author wangtianchuan 2021/6/19
 *
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 */
public class Title96 {
    public static int countTrees(int n){
        int[] d = new int[n + 1];
        d[0] = 1;
        d[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int m = 1; m <= i; m++){
                // m 做根节点, m 左边有 m - 1 个节点, m 右边有 i - m 个节点
                d[i] += d[m - 1] * d[i - m];
            }
        }
        return d[n];
    }

    /**
     * 事实上我们在方法一中推导出的 G(n)函数的值在数学上被称为卡塔兰数
     *
     *  。卡塔兰数更便于计算的定义如下:
     *  G(0) = 1;
     *  G(n + 1) = G(n) * 2 * (2 * n + 1) / (n + 2)
     *  来源:  leetcode
     */

    public static void main(String[] args) {
        System.out.println(countTrees(2));
    }
}
