package exercise.lc.middle;

import exercise.bean.ListNode;

/**
 * @author wangtianchuan 2021/8/20
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class Title24 {
    public static void main(String[] args) {
        Title24 t = new Title24();
        System.out.println(t.swapPairs(new ListNode(new int[]{1})));
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode before = dummy;
        ListNode nextHead;
        while (head != null){
            ListNode body = head.next;
            if (body == null){
                before.next = head;
                head = null;
            } else {
                before.next = body;
                nextHead = body.next;
                body.next = head;
                head.next = null;
                before = head;
                head = nextHead;
            }
        }
        return dummy.next;
    }
}
