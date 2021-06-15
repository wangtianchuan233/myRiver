package exercise.lc.easy;

import exercise.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtianchuan
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 *
 * 示例 1：
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 *        5
 *      /  \
 *     3    6
 *    / \    \
 *   2  4     8
 *  /        / \
 * 1        7  9
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *   1
 *    \
 *     2
 *      \
 *       3
 *        \
 *         4
 *          \
 *           5
 *            \
 *             6
 *              \
 *               7
 *                \
 *                 8
 *                  \
 *                   9
 *
 * 示例 2：
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 *
 * 提示：
 *
 * 树中节点数的取值范围是 [1, 100]
 * 0 <= Node.val <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title897 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        final TreeNode treeNode = new Title897().increasingBST2(root);
        System.out.println();
    }
    /*
    第一次遍历二叉树, 把所有val存入到一个list中
    第二次遍历list, 按顺序生成一个新的二叉树
     */
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        m(root, nodes);
        if (nodes.size() > 0){
            root = new TreeNode(nodes.get(0));
        }
        TreeNode temp = root;
        for (int i = 1; i < nodes.size(); i++){
            temp.right = new TreeNode(nodes.get(i));
            temp = temp.right;
        }
        return root;
    }
    public void m(TreeNode root, List<Integer> nodes){
        if (root == null) return;
        m(root.left, nodes);
        nodes.add(root.val);
        m(root.right, nodes);
    }

    /*
    直接修改引用, 一次遍历
     */
    private TreeNode temp;
    public TreeNode increasingBST2(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        temp = dummyNode;
        n(root);
        return dummyNode.right;
    }

    public void n(TreeNode root){
        if (root == null) return;
        n(root.left);
        temp.right = root;
        temp = root;
        root.left = null;
        n(root.right);
    }
}
