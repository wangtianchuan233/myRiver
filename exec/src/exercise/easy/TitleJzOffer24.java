package exercise.easy;

import exercise.util.ListNode;

/**
 * @author wangtianchuan
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class TitleJzOffer24 {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        final ListNode listNode = new TitleJzOffer24().reverseList(root);
    }

    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null){
            // 保存下一个节点的引用
            next = cur.next;
            // 本节点的next指向前一个节点
            cur.next = last;
            // 顺序后移
            last = cur;
            cur = next;
        }
        return last;
    }


    /* TODO
     * 翻转链表中的第 left ~ 第 right 个节点
     * node0 -> BEFORE ->  left ->  node3 ->  node4 ->  right -> AFTER ->  node7
     * 截断前后尾
     * node0 -> BEFORE     left ->  node3 ->  node4 ->  right    AFTER ->  node7
     * 翻转第 left ~ 第right个节点
     * node0 -> BEFORE     left <-  node3 <-  node4 <-  right    AFTER ->  node7
     *
     * 按照图示重新连起来
     *                      →→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→
     *                     ↑                                      ↓
     * node0 -> BEFORE     left <-  node3 <-  node4 <-  right    AFTER ->  node7
     *             ↓                                     ↑
     *              →→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→→
     */

    private void reverse(ListNode dummyNode, int left, int right) {
        int index = 0;
        ListNode last = dummyNode;
        ListNode current = dummyNode.next;
        ListNode next = null;
        while (current != null) {
            index++;

        }
    }
}
