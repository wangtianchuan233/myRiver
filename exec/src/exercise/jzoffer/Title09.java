package exercise.jzoffer;

import java.util.Stack;

/**
 * @author wangtianchuan
 * 
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 *
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对appendTail、deleteHead 进行10000次调用
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * class CQueue {
 *
 *     public CQueue() {
 *
 *     }
 *
 *     public void appendTail(int value) {
 *
 *     }
 *
 *     public int deleteHead() {
 *
 *     }
 * }
 *
 *
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 *
 */
public class Title09 {
    public static void main(String[] args) {
        CQueue c = new CQueue();
        System.out.println("null");
        System.out.println(c.deleteHead());
        c.appendTail(5);
        System.out.println("null");
        c.appendTail(2);
        System.out.println("null");
        System.out.println(c.deleteHead());
        System.out.println(c.deleteHead());
    }
}

class CQueue {

    private int addStackSize;

    private int delStackSize;

    // 添加时向 addStack 添加
    private Stack<Integer> addStack;

    // 删除时如果 delStack没有元素, 就把所有元素转移到 delStack, 使用 delStack pop 减少
    private Stack<Integer> delStack;


    public CQueue() {
        addStack = new Stack<>();
        delStack = new Stack<>();
    }

    public void appendTail(int value) {

        /*while (addStackSize == 0 && delStackSize > 0) {
            addStack.push(delStack.pop());
            delStackSize--;
            addStackSize++;
        }*/

        addStackSize++;
        addStack.push(value);
    }

    public int deleteHead() {

        if (delStackSize == 0) {
            while (addStackSize > 0) {
                delStack.push(addStack.pop());
                addStackSize--;
                delStackSize++;
            }
        }

        if (delStackSize == 0) {
            return -1;
        }
        delStackSize--;
        return delStack.pop();
    }

}