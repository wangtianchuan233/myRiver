package exercise.lc.middle;

import exercise.bean.ListNode;

/**
 * @author wangtianchuan 2021/8/5
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        int cur = 0, next = 0;
        while(l1 != null || l2 != null){
            cur = (l1 != null? l1.val : 0) + (l2 != null ? l2.val : 0) + next;
            next = 0;
            if (cur > 9){
                next = cur / 10;
                cur %= 10;
            }
            curNode.next = new ListNode(cur);
            curNode = curNode.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (next != 0){
            curNode.next = new ListNode(next);
        }
        return dummyNode.next;
    }
}
