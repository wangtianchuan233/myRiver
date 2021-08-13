package exercise.lc.easy;

import exercise.bean.TreeNode;

/**
 * @author wangtianchuan 2021/8/13
 *
 * https://leetcode-cn.com/problems/path-sum/
 */
public class Title112 {
    public static void main(String[] args) {
        Title112 t = new Title112();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        System.out.println(t.hasPathSum(root, 6));
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, false);
    }
    public boolean dfs(TreeNode node, int targetSum, boolean ans){
        if (node == null){
            return false;
        }
        if(node.left == null && node.right == null){
            return targetSum - node.val == 0;
        }
        ans = ans || dfs(node.left, targetSum - node.val, ans);
        ans = ans || dfs(node.right, targetSum - node.val, ans);
        return ans;
    }
}
