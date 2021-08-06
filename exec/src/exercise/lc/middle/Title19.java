package exercise.lc.middle;

import exercise.bean.ListNode;

/**
 * @author wangtianchuan 2021/8/6
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class Title19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 2;
        Title19 t = new Title19();
        System.out.println(t.removeNthFromEnd(head, n));
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode idx = dummyNode;
        int count = 0;
        while (count < n){
            idx = idx.next;
            count++;
        }
        ListNode targetLast = dummyNode;
        while(idx.next != null){
            targetLast = targetLast.next;
            idx = idx.next;
        }

        if (targetLast.next.next == null){
            targetLast.next = null;
        } else {
            targetLast.next = targetLast.next.next;
        }
        return dummyNode.next;
    }
}
