package exercise.lc.middle;

/**
 * @author wangtianchuan 2021/6/17
 * 
 * 给定一个整数数组prices，其中第i个元素代表了第 i 天的股票价格 ；非负整数fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 示例 1:
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:  
 * 在此处买入prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润:((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 *
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title714 {
    /*
        greedy

        我们用 buy 表示在最大化收益的前提下，如果我们手上拥有一支股票，那么它的最低买入价格是多少。
        在初始时，buy 的值为 prices[0] 加上手续费 fee。

        那么当我们遍历到第 i(i>0) 天时：
        如果当前的股票价格 prices[i] 加上手续费 fee 小于 buy，那么与其使用 buy 的价格购买股票，
        我们不如以 prices[i]+fee 的价格购买股票，因此我们将 buy 更新为 prices[i]+fee；
        如果当前的股票价格 prices[i] 大于 buy，那么我们直接卖出股票并且获得 prices[i]−buy 的收益。

        但实际上，我们此时卖出股票可能并不是全局最优的（例如下一天股票价格继续上升），
        因此我们可以提供一个反悔操作，看成当前手上拥有一支买入价格为 prices[i] 的股票，将 buy 更新为 prices[i]。
        这样一来，如果下一天股票价格继续上升，我们会获得 prices[i+1] − prices[i] 的收益，
        加上这一天 prices[i]−buy 的收益，恰好就等于在这一天不进行任何操作，而在下一天卖出股票的收益；

        对于其余的情况，prices[i] 落在区间 [buy−fee,buy] 内，它的价格没有低到我们放弃手上的股票去选择它，
        也没有高到我们可以通过卖出获得收益，因此我们不进行任何操作。

        上面的贪心思想可以浓缩成一句话，即当我们卖出一支股票时，我们就立即获得了以相同价格并且免除手续费买入一支股票的权利。
        在遍历完整个数组 prices 之后之后，我们就得到了最大的总收益。

        作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-han-sh-rzlz/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int buy = prices[0] + fee;
        for(int i = 0; i < prices.length; i++){
            if (prices[i] > buy){
                profit += prices[i] - buy;
                buy = prices[i];
            } else if (prices[i] + fee < buy){
                buy = prices[i] + fee;
            }
        }
        return profit;
    }

    /*
        dynamic
        
        考虑到「不能同时参与多笔交易」，因此每天交易结束后只可能存在手里有一支股票或者没有股票的状态。
        
        定义状态
        dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润，
        dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（i 从 0 开始）。
        
        考虑 dp[i][0] 的转移方程，如果这一天交易完后手里没有股票，
        那么可能的转移状态为前一天已经没有股票，即 dp[i−1][0]，
        或者前一天结束的时候手里持有一支股票，即 dp[i−1][1]，
        这时候我们要将其卖出，并获得 prices[i] 的收益，但需要支付 fee 的手续费。因此为了收益最大化，我们列出如下的转移方程：
        
        dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]−fee}
        
        再来按照同样的方式考虑 dp[i][1] 按状态转移，
        那么可能的转移状态为前一天已经持有一支股票，即 dp[i−1][1]，
        或者前一天结束时还没有股票，即 dp[i−1][0]，
        这时候我们要将其买入，并减少 prices[i] 的收益。可以列出如下的转移方程：
        
        dp[i][1]=max{dp[i−1][1],dp[i−1][0]−prices[i]}
        
        对于初始状态，根据状态定义我们可以知道第 0 天交易结束的时候有 dp[0][0]=0 以及 dp[0][1]=−prices[0]。
        
        因此，我们只要从前往后依次计算状态即可。由于全部交易结束后，持有股票的收益一定低于不持有股票的收益，
        因此这时候 dp[n−1][0] 的收益必然是大于 dp[n−1][1] 的，最后的答案即为 dp[n−1][0]。
        
        作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-han-sh-rzlz/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int maxProfit2(int[] prices, int fee) {
        int[][] d = new int[prices.length][2];
        d[0][0] = 0;
        d[0][1] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            d[i][0] = Math.max(d[i - 1][0], d[i - 1][1] + prices[i] - fee);
            d[i][1] = Math.max(d[i - 1][1], d[i - 1][0] - prices[i]);
        }
        return d[prices.length - 1][0];
    }

    public int maxProfit3(int[] prices, int fee) {
        int[] d = new int[2];
        d[0] = 0;
        d[1] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            int t = d[0];
            d[0] = Math.max(d[0], d[1] + prices[i] - fee);
            d[1] = Math.max(d[1], t - prices[i]);
            // shang mian de he xia mian de  yi yang ????
            // d[0] = Math.max(d[0], d[1] + prices[i] - fee);
            // d[1] = Math.max(d[1], d[0] - prices[i]);
        }
        return d[0];
    }


}
