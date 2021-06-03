package exercise.middle;

import java.util.Arrays;

/**
 * @author wangtianchuan
 * 
 * 给你一个下标从 0 开始的正整数数组candiesCount，其中candiesCount[i]表示你拥有的第i类糖果的数目。
 * 同时给你一个二维数组queries，其中queries[i] = [favoriteTypei, favoriteDayi, dailyCapi]。
 *
 * 你按照如下规则进行一场游戏：
 *
 * 你从第0天开始吃糖果。
 * 你在吃完 所有第 i - 1类糖果之前，不能吃任何一颗第 i类糖果。
 * 在吃完所有糖果之前，你必须每天 至少吃 一颗糖果。
 * 请你构建一个布尔型数组answer，满足answer.length == queries.length 。answer[i]为true的条件是：
 * 在每天吃 不超过 dailyCapi颗糖果的前提下，你可以在第favoriteDayi天吃到第favoriteTypei类糖果；否则 answer[i]为 false。
 * 注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
 *
 * 请你返回得到的数组answer。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
 * 输出：[true,false,true]
 * 提示：
 * 1- 在第 0 天吃 2 颗糖果(类型 0），第 1 天吃 2 颗糖果（类型 0），第 2 天你可以吃到类型 0 的糖果。
 * 2- 每天你最多吃 4 颗糖果。即使第 0 天吃 4 颗糖果（类型 0），第 1 天吃 4 颗糖果（类型 0 和类型 1），
 *    你也没办法在第 2 天吃到类型 4 的糖果。换言之，你没法在每天吃 4 颗糖果的限制下在第 2 天吃到第 4 类糖果。
 * 3- 如果你每天吃 1 颗糖果，你可以在第 13 天吃到类型 2 的糖果。
 * 示例 2：
 *
 * 输入：candiesCount = [5,2,6,4,1], queries = [[3,1,2],[4,10,3],[3,10,100],[4,100,30],[1,3,1]]
 * 输出：[false,true,true,false,false]
 * 
 *
 * 提示：
 *
 * 1 <= candiesCount.length <= 105
 * 1 <= candiesCount[i] <= 105
 * 1 <= queries.length <= 105
 * queries[i].length == 3
 * 0 <= favoriteTypei < candiesCount.length
 * 0 <= favoriteDayi <= 109
 * 1 <= dailyCapi <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * [[true,true,true,true,true,
 *   true,true,true,false,false,
 *   true,true,false,false,false,
 *   true,true,false,false,false,
 *   false,false,false,false,false,
 *   true,false,false,false,false,
 *   true,
 * [[true,true,true,true,true,
 * true,true,true,false,false,
 * true,true,false,false,false,
 * true,true,false,false,false,
 * false,false,false,false,false,
 * true,false,false,false,false,
 *   false,
 */
public class Title1744 {
    public static void main(String[] args) {
        int[] c = {16,38,8,41,30,31,14,45,3,2,24,23,38,30,31,17,35,4,9,42,28,18,37,18,14,46,11,13,19,3,5,39,24,48,20,29,4,19,36,11,28,49,38,16,23,24,4,22,29,35,45,38,37,40,2,37,8,41,33,8,40,27,13,4,33,5,8,14,19,35,31,8,8};
        int[][] q = {{58,977,13}};
        System.out.println(Arrays.toString(new Title1744().canEat2(c,q)));
        /*String s =
                "[[35,669,5],[72,822,74],[47,933,94],[62,942,85],[42,596,11]," +
                "[56,1066,18],[54,571,45],[39,890,100],[3,175,26],[48,1489,37]," +
                "[40,447,52],[30,584,7],[26,1486,38],[21,1142,21],[9,494,96]," +
                "[56,759,81],[13,319,16],[20,1406,57],[11,1092,19],[24,670,67]," +
                "[38,1702,33],[5,676,32],[50,1386,77],[36,1551,87],[29,1445,13]," +
                "[58,977,13],[7,887,64],[37,1396,23],[0,765,69],[40,1083,86],[43,1054,49],[48,690,92],[28,1201,56],[47,948,43],[57,233,25],[32,1293,65],[0,1646,34],[43,1467,39],[39,484,23],[21,1576,69],[12,1222,68],[9,457,83],[32,65,9],[10,1424,42],[35,534,3],[23,83,22],[33,501,33],[25,679,51],[2,321,42],[1,240,68],[7,1297,42],[45,480,72],[26,1472,9],[6,649,90],[26,361,57],[49,1592,7],[11,158,95],[35,448,24],[41,1654,10],[61,510,43],[31,1230,95],[11,1471,12],[37,43,84],[56,1147,48],[69,1368,65],[22,170,24],[56,192,80],[34,1207,69],[1,1226,22],[37,1633,50],[11,98,58],[17,125,13],[0,1490,5],[37,1732,43],[45,793,14],[16,578,72],[50,241,78]]";
        */
    }


    /**
     * 数据过大, int类型溢出
     */
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        // 糖果数量 candiesCount 数组的前缀和数组 arr
        int[] arr = new int[candiesCount.length];
        arr[0] = candiesCount[0];
        for(int i = 1; i < arr.length; i++){
            arr[i] = arr[i - 1] + candiesCount[i];
        }
        boolean[] res = new boolean[queries.length];
        /*
        要在 第 a 天 迟到 第 b 种糖果, 每天最少吃 1 颗, 最多吃 c 颗,  需要:
         1 包括第 a 天, 这些天能够吃掉的最多的糖果数要 > 前 (b - 1) 糖果数量总和
         2 前 b 种糖果数量总和 > 天数 (a - 1)

         a : queries[i][1]
         b : queries[i][0]
         c : queries[i][2]

         这些天能够吃掉的最多的糖果数 = queries[i][2] * (queries[i][1] + 1);
         前 (b - 1) 糖果数量总和 = arr[queries[i][0] - 1];
         前 b 种糖果数量总和 = arr[queries[i][0]]
         天数 (a - 1) = queries[i][1]

         当 b = 0 时, 只需要 arr[queries[i][0]] >

         */
        for(int i = 0; i < queries.length; i++){
            final int i1;
            if (queries[i][0] > 0){
                i1 = arr[queries[i][0] - 1];
                res[i] = queries[i][2] * (queries[i][1] + 1) > i1 && arr[queries[i][0]] > queries[i][1];
            } else{
                res[i] = arr[queries[i][0]] > queries[i][1];
            }
        }
        return res;

    }

    public boolean[] canEat3(int[] candiesCount, int[][] queries) {
        // 糖果数量 candiesCount 数组的前缀和数组 arr
        long[] arr = new long[candiesCount.length];
        arr[0] = candiesCount[0];
        for(int i = 1; i < arr.length; i++){
            arr[i] = arr[i - 1] + candiesCount[i];
        }
        boolean[] res = new boolean[queries.length];
        /*
        要在 第 a 天 迟到 第 b 种糖果, 每天最少吃 1 颗, 最多吃 c 颗,  需要:
         1 包括第 a 天, 这些天能够吃掉的最多的糖果数要 > 前 (b - 1) 糖果数量总和
         2 前 b 种糖果数量总和 > 天数 (a - 1)

         a : queries[i][1]
         b : queries[i][0]
         c : queries[i][2]

         这些天能够吃掉的最多的糖果数 = queries[i][2] * (queries[i][1] + 1);
         前 (b - 1) 糖果数量总和 = arr[queries[i][0] - 1];
         前 b 种糖果数量总和 = arr[queries[i][0]]
         天数 (a - 1) = queries[i][1]

         当 b = 0 时, 只需要 arr[queries[i][0]] >

         */
        for(int i = 0; i < queries.length; i++){
            final long i1;
            if (queries[i][0] > 0){
                i1 = arr[queries[i][0] - 1];
                res[i] = queries[i][2] * (queries[i][1] + 1L) > i1 && arr[queries[i][0]] > queries[i][1];
            } else{
                res[i] = arr[queries[i][0]] > queries[i][1];
            }
        }
        return res;

    }

    /**
     * 官方答案
     */
    public boolean[] canEat2(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;

        // 前缀和
        long[] sum = new long[n];
        sum[0] = candiesCount[0];
        for (int i = 1; i < n; ++i) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }

        int q = queries.length;
        boolean[] ans = new boolean[q];
        for (int i = 0; i < q; ++i) {
            int[] query = queries[i];
            int favoriteType = query[0], favoriteDay = query[1], dailyCap = query[2];

            long x1 = favoriteDay + 1;
            long y1 = (long) (favoriteDay + 1) * dailyCap;
            long x2 = favoriteType == 0 ? 1 : sum[favoriteType - 1] + 1;
            long y2 = sum[favoriteType];

            ans[i] = !(x1 > y2 || y1 < x2);
        }
        return ans;
    }

}


