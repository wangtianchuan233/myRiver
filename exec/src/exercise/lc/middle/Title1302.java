package exercise.lc.middle;

import exercise.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangtianchuan 2021/8/18
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 * https://leetcode-cn.com/problems/deepest-leaves-sum/
 */
public class Title1302 {
    public static void main(String[] args) {
        Integer[] vals = new Integer[]{1,2,3,4,5,null,6,7,null,null,null,null,8};
        TreeNode root = new TreeNode(vals);
        Title1302 t = new Title1302();
        System.out.println(t.deepestLeavesSum(root));
    }
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }
        int ans = 0;
        while (!q.isEmpty()){
            int n = q.size();
            ans = 0;
            for(int i = 0; i < n; i++){
                TreeNode node = q.poll();
                ans += node.val;
                if (node.left != null){
                    q.offer(node.left);
                }
                if (node.right != null){
                    q.offer(node.right);
                }
            }
        }
        return ans;
    }
}
