package exercise.lc.easy;

import exercise.bean.ListNode;

/**
 * @author wangtianchuan 2021/8/17
 *
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * 输入：listA = [4,1,8,4,5], listB = [5,0,1,8,4,5]
 * 输出  8
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title160 {
    public static void main(String[] args) {
        Title160 t = new Title160();
        int[] l1 = {1};
        int[] l2 = {4,1,8,4,5};
        ListNode root1 = new ListNode(l1);
        ListNode root2 = new ListNode(l2);
        System.out.println(root1);
        System.out.println(root2);
        System.out.println(t.getIntersectionNode(root1, root1));
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode indexA = headA, indexB = headB;
        while(indexA != null || indexB != null){
            if (indexB != null && indexA == indexB && indexA.val != 0){
                return indexA;
            }
            if (indexA == null){
                indexA = headB;
            } else {
                indexA = indexA.next;
            }
            if (indexB == null){
                indexB = headA;
            } else {
                indexB = indexB.next;
            }
            if (indexB != null && indexA == indexB && indexA.val != 0){
                return indexA;
            }
        }
        return null;
    }
}
