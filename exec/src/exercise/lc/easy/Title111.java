package exercise.lc.easy;

import exercise.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangtianchuan 2021/8/17
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class Title111 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
//        root.right= new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        Title111 t = new Title111();
        System.out.println(t.minDepth(root));
    }

    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ans = 1;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i < n; i++){
                TreeNode poll = q.poll();
                if (poll.left == null && poll.right == null){
                    return ans;
                }
                if (poll.left != null){
                    q.offer(poll.left);
                }
                if (poll.right != null){
                    q.offer(poll.right);
                }
            }
            ans++;
        }
        return ans;
    }
    // 6ms
    /*public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        } else if (root.left == null) {
            return 1 + minDepth(root.right);
        } else if (root.right == null){
            return 1 + minDepth(root.left);
        } else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }*/
}
