package exercise.bean;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangtianchuan
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
