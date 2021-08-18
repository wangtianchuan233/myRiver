package exercise.lc.middle;

import exercise.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wangtianchuan 2021/8/18
 */
public class Title637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }
        while (!q.isEmpty()){
            int n = q.size();
            long sum = 0;
            for(int i = 0; i < n; i++){
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null){
                    q.offer(node.left);
                }
                if (node.right != null){
                    q.offer(node.right);
                }
            }
            ans.add((sum + 0.0) / n );
        }
        return ans;
    }
}
