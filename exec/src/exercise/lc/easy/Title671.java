package exercise.lc.easy;

import exercise.bean.TreeNode;

/**
 * @author wangtianchuan 2021/7/27
 * 
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为2或0。
 * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 *
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title671 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Title671 t = new Title671();
        System.out.println(t.findSecondMinimumValue(root));
    }
    public int findSecondMinimumValue(TreeNode root) {
        int ans = find(root, -1, root.val);
        return ans;
    }

    private int find(TreeNode root, int ans, int min) {
        if (root == null){

        } else if (root.val > min){
            if (ans == -1){
                ans = root.val;
            } else {
                ans = Math.min(root.val, ans);
            }
        } else {
            ans = find(root.left, ans, min);
            ans = find(root.right, ans, min);
        }
        return ans;
    }
}
