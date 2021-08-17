package exercise.lc.easy;

import exercise.bean.TreeNode;

/**
 * @author wangtianchuan 2021/8/17
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class Title110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right= new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        //root.left.left.left = new TreeNode(1);
        System.out.println(new Title110().isBalanced(null));
    }
    public boolean isBalanced(TreeNode root) {
        return isBal(root) >= 0;
    }
    public int isBal(TreeNode node){
        if (node == null) return 0;
        int depth1 = isBal(node.left);
        if (depth1 < 0) {
            return depth1;
        }
        int depth2 = isBal(node.right);
        if (depth2 < 0) {
            return depth2;
        }
        if (Math.abs(depth1 - depth2) > 1){
            return -1;
        }
        return 1 + Math.max(depth1, depth2);
    }
}
