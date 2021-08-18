package exercise.lc.middle;

import exercise.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangtianchuan 2021/8/18
 *
 * 给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original中的目标节点target。
 *
 * 其中，克隆树 cloned是原始树 original的一个 副本 。
 *
 * 请找出在树cloned中，与target相同的节点，并返回对该节点的引用（在 C/C++ 等有指针的语言中返回 节点指针，其他语言返回节点本身）。
 *
 * 注意：
 *
 * 你 不能 对两棵二叉树，以及 target节点进行更改。
 * 只能 返回对克隆树cloned中已有的节点的引用。
 *
 * 提示：
 *
 * 树中节点的数量范围为[1, 10^4]。
 * 同一棵树中，没有值相同的节点。
 * target节点是树original中的一个节点，并且不会是null。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Title1379 {

    /*
     * dfs 1ms
     */
    public final TreeNode getTargetCopydfs(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned != null){
            if (cloned.val == target.val) {
                return cloned;
            }
            TreeNode left = getTargetCopydfs(null, cloned.left, target);
            if (left != null && left.val == target.val) {
                return left;
            }
            TreeNode right = getTargetCopydfs(null, cloned.right, target);
            if (right != null && right.val == target.val) {
                return right;
            }
        }
        return null;
    }
    /*
     * bfs 7ms
     */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> q = new LinkedList<>();
        if (cloned != null) {
            q.offer(cloned);
        }
        while (!q.isEmpty()){
            for(int i = 0; i < q.size(); i++){
                TreeNode node = q.poll();
                if (node.val == target.val){
                    return node;
                }
                if (node.left != null){
                    q.offer(node.left);
                }
                if (node.right != null){
                    q.offer(node.right);
                }
            }
        }
        return null;
    }
}
