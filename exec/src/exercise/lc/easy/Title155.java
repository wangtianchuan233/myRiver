package exercise.lc.easy;

import java.util.Stack;

/**
 * @author wangtianchuan 2021/8/17
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop()—— 删除栈顶的元素。
 * top()—— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title155 {

    static class MinStack {

        private final Stack<Integer> value;
        private final Stack<Integer> min;

        public MinStack() {
            value = new Stack<>();
            min = new Stack<>();
            min.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            int nextMin = Math.min(min.peek(), val);
            value.push(val);
            min.push(nextMin);
        }

        public void pop() {
            value.pop();
            min.pop();
        }

        public int top() {
            return value.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}
