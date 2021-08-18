package exercise.bean;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangtianchuan
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(Integer[] array){
        int n = array.length;
        if (n < 1){
            return;
        }
        this.val = array[0];
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(this);
        int k = 1;
        while (!q.isEmpty()){
            for(int i = 0; i < q.size(); i++){
                TreeNode node = q.poll();
                if (k < n && array[k] != null){
                    node.left = new TreeNode(array[k]);
                    q.offer(node.left);
                }
                k++;
                if (k < n && array[k] != null){
                    node.right = new TreeNode(array[k]);
                    q.offer(node.right);
                }
                k++;
            }
        }
    }
}
