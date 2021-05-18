package exercise.util;

/**
 * @author wangtianchuan
 *
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public int len(){
        return getLen(this);
    }

    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len ++;
            head = head.next;
        }
        return len;
    }

}
