package exercise.lc.middle;

import java.util.Arrays;

/**
 * @author wangtianchuan
 * 
 * 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
 *
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 *
 * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 *
 * 注意：Tony 可以按任意顺序购买雪糕。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：costs = [1,3,2,4,1], coins = 7
 * 输出：4
 * 解释：Tony 可以买下标为 0、1、2、4 的雪糕，总价为 1 + 3 + 2 + 1 = 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-ice-cream-bars
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * []
 *
 */
public class Title1833 {
    public static void main(String[] args) {
        int[] costs = {2, 2, 2, 2, 2, 1, 2, 2};
        int coins = 9;
        System.out.println(maxIceCream4(costs, coins));
    }

    /*
        时间复杂度 O(n log(n)), 空间复杂度 O(1)
     */
    public int maxIceCream2(int[] costs, int coins) {
        Arrays.sort(costs);
        int i = 0;
        while(i < costs.length&&coins >= costs[i]  ){
            coins -= costs[i++];
        }
        return i;
    }

    public static int maxIceCream4(int[] costs, int coins) {
        int min = 0, max = 0;
        for(int x : costs){
            if (x > max){
                max = x;
            } else if ( x < min){
                min = x;
            }
        }
        final int len = max - min + 1;
        int[] d = new int[len];
        for(int x : costs){
            d[x - min]++;
        }
        int i = 0;
        int res = 0;
        while(i < d.length && coins >= i){
            if (d[i] == 0){
                i++;
                continue;
            } else {
                res++;
                coins -= i;
                d[i]--;
            }
        }
        return res;
    }

    /*
    动态规划 0 1 背包
    时间复杂度O(costs.length * coins)
    空间复杂度O(costs.length * coins)
    其中, 空间复杂度可以优化为 O(coins)

    本题, 内存超出限制;
     */
    public static int maxIceCream(int[] costs, int coins) {
        int[][] d = new int[costs.length][coins + 1];
        // d[i][j] 表示 金币为 j , 买或不买 第 i 个雪糕的 最大数量
        for(int j = 0; j <= coins; j++){
            if(j >= costs[0]){
                d[0][j] = 1;
            }
        }
        for(int i = 1; i < costs.length; i++){
            for(int j = 0; j <= coins; j++){
                if(j >= costs[i]){
                    d[i][j] = Math.max(d[i - 1][j], 1 + d[i - 1][j - costs[i]]);
                } else {
                    d[i][j] = d[i - 1][j];
                }
            }
        }
        return d[costs.length - 1][coins];
    }

    /*
    动态规划 0 1 背包
    时间复杂度O(costs.length * coins)
    空间复杂度O(coins)

    本题, 时间超出限制
     */
    public static int maxIceCream3(int[] costs, int coins) {
        int[] d = new int[coins + 1];
        // d[i][j] 表示 金币为 j , 买或不买 第 i 个雪糕的 最大数量
        for(int j = 0; j <= coins; j++){
            if(j >= costs[0]){
                d[j] = 1;
            }
        }
        for(int i = 1; i < costs.length; i++){
            for(int j = coins; j >= 0 ; j--){
                if(j >= costs[i]){
                    d[j] = Math.max(d[j], 1 + d[j - costs[i]]);
                } else {
                    d[j] = d[j];
                }
            }
        }
        return d[coins];
    }
}
