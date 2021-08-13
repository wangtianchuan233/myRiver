package exercise.lc.easy;

import exercise.bean.TreeNode;

/**
 * @author wangtianchuan 2021/8/13
 *
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title129 {

    public static void main(String[] args) {
        Title129 t = new Title129();
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(0);
        System.out.println(t.sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0, 0);
    }

    private int dfs(TreeNode root, int ans, int e) {
        if (root == null){
            return ans;
        }
        if (root.left == null && root.right == null){
            ans += (e * 10 + root.val);
            return ans;
        }
        e = e * 10 + root.val;
        ans = dfs(root.left, ans, e);
        ans = dfs(root.right, ans, e);
        return ans;
    }
}
