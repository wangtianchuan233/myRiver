package exercise.lc.easy;

import exercise.bean.TreeNode;

/**
 * @author wangtianchuan 2021/7/27
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 
 *
 * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 
 *
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null){
            return t2 == null;
        }
        if (t2 == null){
            return false;
        }
        if (t1.val != t2.val){
            return false;
        }
        return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }
}
