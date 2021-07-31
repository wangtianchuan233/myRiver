package exercise.lc.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtianchuan 2021/7/31
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * <p>
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 * <p>
 * 格雷编码序列必须以 0 开头。
 * <p>
 * 示例
 * <p>
 * 输入:2
 * 输出:[0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * <p>
 * 对于给定的n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1]也是一个有效的格雷编码序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gray-code
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title89 {
    public static void main(String[] args) {
        Title89 t = new Title89();
        System.out.println(t.grayCode(3));
    }

    // 公式
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < 1 << n; i++){
            ans.add(gray(i));
        }
        return ans;
    }

    // 计算 第 i 个格雷码
    public int gray(int i) {
        return i ^ (i >> 1);
    }

    // 镜面反射法
    public List<Integer> grayCode2(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        if (n == 0){
            return ans;
        }
        for(int i = 0; i < n; i++){
            int x = 1 << i;
            for(int j = ans.size() - 1; j >= 0; j--){
                ans.add(ans.get(j) + x);
            }
        }
        return ans;
    }

    // 结果正确, 但是因为顺序问题, 力扣不给通过, 辣鸡力扣;
    public List<Integer> grayCode3(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        if (n == 0)
            return ans;
        backtrack(ans, 0, 1 << n, 0);
        return ans;
    }

    private void backtrack(List<Integer> ans, int cur, int n, int vis) {
        for (int i = 1; i < n; i++) {
            if (ans.size() == n) {
                return;
            }
            if (((vis >> i - 1) & 1) == 0 && Integer.bitCount(i ^ cur) == 1){
                vis += (1 << i - 1);
                ans.add(i);
                backtrack(ans, i, n, vis);
                if (ans.size() == n) {
                    return;
                }
                ans.remove(ans.size() - 1);
                vis -= (1 << i - 1);
            }
        }
    }
}