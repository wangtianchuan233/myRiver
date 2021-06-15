package exercise.lc.easy;

import exercise.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtianchuan
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new Title94().inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        return inorderTraversal(root, list);
    }

    private List<Integer> inorderTraversal(TreeNode root, List<Integer> list){
        if (root == null) return list;
        if (root.left != null) {
            inorderTraversal(root.left, list);
        }
        list.add(root.val);
        if (root.right != null){
            inorderTraversal(root.right, list);
        }
        return list;
    }
}
