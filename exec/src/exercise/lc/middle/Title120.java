package exercise.lc.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtianchuan 2021/6/19
 * 
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title120 {
    /**
     * 迭代
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> last = triangle.get(0);
        List<Integer> cur = null;
        for(int i = 1; i < triangle.size(); i++){
            cur = triangle.get(i);
            cur.set(0, cur.get(0) + last.get(0));
            for(int j = 1; j < cur.size() - 1; j++){
                cur.set(j, Math.min(last.get(j - 1), last.get(j)) + cur.get(j));
            }
            cur.set(cur.size() - 1, last.get(cur.size() - 2) + cur.get(cur.size() - 1));
            last = cur;
        }
        int min = Integer.MAX_VALUE;
        for (Integer x : last) {
            min = Math.min(x, min);
        }
        return min;
    }

    /**
     * 递归, 效率低
     */
    List<List<Integer>> list;
    public int minimumTotal2(List<List<Integer>> triangle) {
        list = triangle;
        return m(0, 0);
    }

    public int m(int i , int j){
        if (i == list.size() - 1){
            return list.get(i).get(j);
        } else {
            return list.get(i).get(j) + Math.min(m(i + 1, j), m(i + 1, j + 1));
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        y.add(2);
        x.add(y);
        y = new ArrayList<>();
        y.add(3);
        y.add(4);
        x.add(y);
        y = new ArrayList<>();
        y.add(6);
        y.add(5);
        y.add(7);
        x.add(y);
        y = new ArrayList<>();
        y.add(4);
        y.add(1);
        y.add(8);
        y.add(3);
        x.add(y);
        System.out.println(minimumTotal(x));
    }
}
