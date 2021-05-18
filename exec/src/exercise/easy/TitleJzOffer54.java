package exercise.easy;

import exercise.util.TreeNode;

/**
 * @author wangtianchuan
 * 给定一棵二叉搜索树, 请找出其中第k大的节点。
 * 
 * 示例 1:
 *    输入: root = [3,1,4,null,2], k = 1
 *      3
 *     / \
 *    1   4
 *         \
 *          2
 * 输出: 4
 * 
 * 示例 2:
 *    输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 * 
 * 限制：
 * 
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TitleJzOffer54 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right= new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        System.out.println(new TitleJzOffer54().kthLargest(root, 3));
    }

    public int kthLargest(TreeNode root, int k) {
        int[] index = {0};
        boolean[] flag = {true};
        int[] res = {0};
        m(root, index, flag, res, k);
        return res[0];
    }

    public void m(TreeNode root, int[] index, boolean[] flag, int[] res, int k){
        if (root.right != null && flag[0]){
            m(root.right, index, flag, res, k);
        }
        if (++index[0] == k){
            flag[0] = false;
            res[0] = root.val;
        }
        if (root.left != null && flag[0]){
            m(root.left, index, flag, res, k);
        }
    }
}
