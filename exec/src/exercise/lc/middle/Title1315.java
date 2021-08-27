package exercise.lc.middle;

import exercise.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangtianchuan 2021/8/27
 *给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 *
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent/
 */
public class Title1315 {
    public static void main(String[] args) {
        Title1315 t = new Title1315();
        Integer[] a = {6,7,8,2,7,1,3,9,null,1,4,null,null,null,5};
        TreeNode root = new TreeNode(a);
        System.out.println(t.sumEvenGrandparent2(root));
    }

    /**
     * dfs
     */
    public int sumEvenGrandparent2(TreeNode root) {
        int ans = 0;
        ans += dfs(1, 1, root);
        return ans;
    }

    private int dfs(int grandFather, int father, TreeNode node) {
        int ans = 0;
        if (node == null){
            return ans;
        }
        if (grandFather % 2 == 0){
            ans = node.val;
        }
        ans += dfs(father, node.val, node.left);
        ans += dfs(father, node.val, node.right);
        return ans;
    }

    /**
     * bfs
     */
    public int sumEvenGrandparent(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> line = new LinkedList<>();
        line.offer(root);
        while (!line.isEmpty()){
            int n = line.size();
            for(int i = 0; i < n; i++){
                TreeNode poll = line.poll();
                if (poll != null) {
                    if (poll.val % 2 == 0) {
                        ans += sumGrandChildren(poll);
                    }
                    line.offer(poll.left);
                    line.offer(poll.right);
                }
            }
        }
        return ans;
    }

    private int sumGrandChildren(TreeNode root) {
        int ans = 0;
        if (root.left != null){
            ans += sumChildren(root.left);
        }
        if (root.right != null){
            ans += sumChildren(root.right);
        }
        return ans;
    }

    private int sumChildren(TreeNode root) {
        int ans = 0;
        if (root.left != null){
            ans += root.left.val;
        }
        if (root.right != null){
            ans += root.right.val;
        }
        return ans;
    }
}
