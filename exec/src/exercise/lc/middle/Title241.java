package exercise.lc.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtianchuan 2021/8/20
 * 
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
 * 你需要给出所有可能的组合的结果。有效的运算符号包含 +,-以及*。
 *
 * 示例1:
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0 
 * (2-(1-1)) = 2
 *
 * 示例2:
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释: 
 * (2*(3-(4*5))) = -34 
 * ((2*3)-(4*5)) = -14 
 * ((2*(3-4))*5) = -10 
 * (2*((3-4)*5)) = -10 
 * (((2*3)-4)*5) = 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title241 {
    public static void main(String[] args) {
        Title241 t = new Title241();
        System.out.println(t.diffWaysToCompute("11"));
    }
    public List<Integer> diffWaysToCompute(String expression) {
        return diffWaysToCompute(expression, 0, expression.length() - 1);
    }

    private List<Integer> diffWaysToCompute(String expression, int l, int r) {
        List<Integer> ans = new ArrayList<>();
        if (isDigit(expression, l, r)){
            ans.add(Integer.valueOf(expression.substring(l, r + 1)));
        } else {
            for (int i = l + 1; i < r; i++) {
                char c = expression.charAt(i);
                if (c < 48) {
                    List<Integer> left = diffWaysToCompute(expression, l, i - 1);
                    List<Integer> right = diffWaysToCompute(expression, i + 1, r);
                    for (Integer a : left) {
                        for (Integer b : right) {
                            ans.add(calculate(a, c, b));
                        }
                    }
                }
            }
        }
        return ans;
    }

    private boolean isDigit(String expression, int l, int r) {
        for(int i = l; i <= r; i++){
            if (!Character.isDigit(expression.charAt(i))){
                return false;
            }
        }
        return true;
    }

    private int calculate(int a, char c, int b) {
        if (c == '+'){
            return a + b;
        } else if (c == '-') {
            return a - b;
        } else {
            return a * b;
        }
    }

}
