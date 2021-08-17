package exercise.lc.easy;

import exercise.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wangtianchuan 2021/8/17
 * 二叉树的前序遍历 (根左右)
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class Title144 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Title144 t = new Title144();
        System.out.println(t.preorderTraversal(root));
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode t = null;
        while (stack.size() > 0 || t != null){
            if (t != null) {
                ans.add(t.val);
                stack.push(t.right);
                t = t.left;
            } else {
                t = stack.pop();
            }
        }
        return ans;
    }
}
