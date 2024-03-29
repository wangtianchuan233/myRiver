package exercise.lc.middle;

import exercise.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangtianchuan 2021/7/19
 * 
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \ 
 *      3   1
 *
 * 输出: 7 
 * 解释:小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \ 
 *  1   3   1
 *
 * 输出: 9
 * 解释:小偷一晚能够盗取的最高金额= 4 + 5 = 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Title337 {
    public static void main(String[] args) {
        Title337 t = new Title337();
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);
        right.right = new TreeNode(1);
        System.out.println(t.rob(root));
    }
    // 递归超时
    /*public int rob(TreeNode root) {
        return Math.max(robNode(root), noRobNode(root));
    }
    private int robNode(TreeNode node){
        // 如果抢节点 node, 那么必定不抢它的 left 和 right
        if (node == null){
            return 0;
        }
        return node.val + noRobNode(node.left) + noRobNode(node.right);
    }
    private int noRobNode(TreeNode node){
        // 如果不抢节点 node, 那么它的 left 和 right 可以选择抢或者不抢
        if (node == null){
            return 0;
        }
        return Math.max(robNode(node.left), noRobNode(node.left)) + Math.max(robNode(node.right), noRobNode(node.right));
    }*/
    private Map<String, Integer> robMap = new HashMap<>();
    private Map<String, Integer> noRobMap = new HashMap<>();
    public int rob(TreeNode root) {
        return Math.max(robNode(root), noRobNode(root));
    }
    private int robNode(TreeNode node){
        // 如果抢节点 node, 那么必定不抢它的 left 和 right
        if (node == null){
            return 0;
        }
        Integer res = robMap.get(node.toString());
        if (res != null){
            return res;
        }
        res = node.val + noRobNode(node.left) + noRobNode(node.right);
        robMap.put(node.toString(), res);
        return res;
    }
    private int noRobNode(TreeNode node){
        // 如果不抢节点 node, 那么它的 left 和 right 可以选择抢或者不抢
        if (node == null){
            return 0;
        }
        Integer res = noRobMap.get(node.toString());
        if (res != null){
            return res;
        }
        res = Math.max(robNode(node.left), noRobNode(node.left)) + Math.max(robNode(node.right), noRobNode(node.right));
        noRobMap.put(node.toString(), res);
        return res;
    }
}
