package exercise.lc.hard;

import java.util.Arrays;

/**
 * @author wangtianchuan 2021/7/3
 * 
 * 给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/*
 * prices = [1, 3, 4, 2, 5, 2, 8]
 *
 * buy1 = Math.max(-current, buy1)
 * sell1 = Math.max(buy1 + current, sell1)
 * buy2 = Math.max(sell1 - current, buy2)
 * sell2 = Math.max(buy2 + current, sell2)
 *
 * CUR      buy1  sell1  buy2  sell2  buy3  sell3
 *         -MAX    0     -MAX   0     -MAX   0
 * 1       -1      0     -1     0     -1     0
 * 3       -1      2     -1     2     -1     2
 * 4       -1      3     -1     3     -1     3
 * 2       -1      3     1      3     1      3
 * 5       -1      4     1      6     1      6
 * 3       -1      4     1      6     3      6
 * 8       -1      7     1      9     3      11
 *
 */
public class Title188 {
    public static void main(String[] args) {
        int[] m = {1, 3, 4, 2, 5, 2, 8};
        System.out.println(maxProfit(5, m));
    }
    public static int maxProfit(int k, int[] prices) {
        if (k == 0){
            return 0;
        }
        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy, -1000000000);
        for(int i = 0; i < prices.length; i++){
            int current = prices[i];
            buy[0] = Math.max(buy[0], -current);
            sell[0] = Math.max(sell[0], buy[0] + current);
            for(int j = 1; j < k; j ++){
                buy[j] = Math.max(buy[j], sell[j - 1] - current);
                sell[j] = Math.max(sell[j], buy[j] + current);
            }
        }
        return sell[k - 1];
    }
}
