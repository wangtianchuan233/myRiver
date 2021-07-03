package exercise.lc.hard;

/**
 * @author wangtianchuan 2021/6/28
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 
 *
 * 示例1:
 *
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title123 {
    public static void main(String[] args) {
        int[] m = {1, 2, 3, 4, 1, 3};
        System.out.println(m(m));
    }
    // 7ms
    static int m (int[] prices){
        int maxProfit = 0;
        int buy = prices[0], sell = 0;
        int[] arr = new int[prices.length];
        for(int i = 1; i < prices.length; i++){
            if (prices[i] > buy){
                sell = prices[i];
                arr[i] = Math.max(sell - buy, arr[i - 1]);
            } else {
                buy = prices[i];
                arr[i] = arr[i - 1];
            }
        }
        sell = prices[prices.length - 1];
        int[] arr2 = new int[prices.length];
        for(int i = prices.length - 2; i >= 0; i--){
            if (prices[i] < sell){
                buy = prices[i];
                arr2[i] = Math.max((sell - buy), arr2[i + 1]);
            } else {
                sell = prices[i];
                arr2[i] = arr2[i + 1];
            }
            maxProfit = Math.max(maxProfit, arr[i] + arr2[i]);
        }
        return maxProfit;
    }

    /* 网友执行 2 ms 的答案
     */
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, s1 = 0;
        int buy2 = Integer.MIN_VALUE, s2 = 0;
        int n = prices.length;
        for(int i=0; i<n; i++) {
            int current = prices[i];
            if(buy1 < -current) {
                //第一次买入后的余额，越大越好
                buy1 = -current;
            }
            if(s1 < buy1+current) {
                //第一次卖出后的余额，越大越好
                s1 = buy1+current;
            }
            if(buy2 < s1 -current) {
                //第二次买入的余额为第一次卖出后的余额减去当前价格
                buy2 = s1 -current;
            }
            if(s2 < buy2 + current) {
                //第二次卖出后的余额是第一次买入后的余额加上当前卖出的价格
                s2 = buy2 + current;
            }
        }
        return s2;
    }

}
