package exercise.lc.middle;

import java.util.Arrays;

/**
 * @author wangtianchuan
 * 
 * 给你一个数组points，其中points[i] = [xi, yi]，表示第i个点在二维平面上的坐标。多个点可能会有 相同的坐标。
 *
 * 同时给你一个数组queries，其中queries[j] = [xj, yj, rj]，表示一个圆心在(xj, yj)且半径为rj的圆。
 *
 * 对于每一个查询queries[j]，计算在第 j个圆 内点的数目。如果一个点在圆的 边界上，我们同样认为它在圆内。
 *
 * 请你返回一个数组answer，其中answer[j]是第j个查询的答案
 * 
 * 提示：
 *
 * 1 <= points.length <= 500
 * points[i].length == 2
 * 0 <= xi, yi <= 500
 * 1 <= queries.length <= 500
 * queries[j].length == 3
 * 0 <= xj, yj <= 500
 * 1 <= rj <= 500
 * 所有的坐标都是整数。
 *
 * 示例
 * 输入：points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
 * 输出：[2,3,2,4]
 * 解释：所有的点和圆如上图所示。
 * queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆，queries[3] 是紫色的圆。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queries-on-number-of-points-inside-a-circle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queries-on-number-of-points-inside-a-circle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queries-on-number-of-points-inside-a-circle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title1828 {
    public static void main(String[] args) {
        int[][] points = {{1,1},{2,2},{3,3},{4,4},{5,5}};
        int[][] queries = {{1,2,2},{2,2,2},{4,3,2},{4,3,3}};
        System.out.println(Arrays.toString(new Title1828().countPoints(points, queries)));
    }
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] count = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            for(int j = 0; j < points.length; j++){
                if (Math.pow((points[j][0] - queries[i][0]), 2) + Math.pow((points[j][1] - queries[i][1]), 2) <= Math.pow(queries[i][2], 2)) {
                    count[i]++;
                }
            }
        }
        return count;
    }
}
