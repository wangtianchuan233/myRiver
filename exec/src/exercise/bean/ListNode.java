package exercise.bean;

/**
 * @author wangtianchuan
 *
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) { val = x; }

    public ListNode(int[] vals){
        if (vals.length > 0) {
            this.val = vals[0];
            ListNode t = this;
            for(int i = 1; i < vals.length; i++){
                t.next = new ListNode(vals[i]);
                t = t.next;
            }
        }
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        ListNode t = this;
        while (t != null){
            sb.append(t.val);
            sb.append(',');
            t = t.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        return sb.toString();
    }
}
