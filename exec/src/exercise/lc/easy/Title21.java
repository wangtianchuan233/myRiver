package exercise.lc.easy;

import exercise.bean.ListNode;

/**
 * @author wangtianchuan 2021/6/30
 * 合并两个链表
 */
public class Title21 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        l1.next.next.next = new ListNode(7);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);
        l2.next.next.next = new ListNode(8);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(10);
        l2.next.next.next.next.next.next = new ListNode(11);
        l2.next.next.next.next.next.next.next = new ListNode(12);
        ListNode merged = mergeTwoLists(l1, l2);
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode s1 = l1, s2 = l2;
        ListNode cur = dummyNode;
        while (s1 != null && s2 != null) {
            if (s1.val < s2.val) {
                cur.next = new ListNode(s1.val);
                s1 = s1.next;
            } else {
                cur.next = new ListNode(s2.val);
                s2 = s2.next;
            }
            cur = cur.next;
        }
        while (s1 != null){
            cur.next = new ListNode(s1.val);
            s1 = s1.next;
            cur = cur.next;
        }
        while (s2 != null){
            cur.next = new ListNode(s2.val);
            s2 = s2.next;
            cur = cur.next;
        }
        return dummyNode.next;
    }
}
