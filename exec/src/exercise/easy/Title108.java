package exercise.easy;

import exercise.util.TreeNode;

/**
 * @author wangtianchuan
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * 示例 1：
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 *
 * 示例 2：
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
 * 
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 按 严格递增 顺序排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title108 {

    public static void main(String[] args) {
        final TreeNode treeNode = new Title108().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }

    public TreeNode sortedArrayToBST(int[] nums){
        return sortedArrayToBST(nums, 0, nums.length - 1, new TreeNode());
    }

    /**
     * 把数组 nums 的第 index1~ index2 个元素存储到以 node 为根结点的二叉树上,
     */
    private TreeNode sortedArrayToBST(int[] nums, int index1, int index2, TreeNode node){
        final int avg = (index1 + index2) / 2;
        node.val = nums[avg];
        if (index1 < avg){
            node.left = new TreeNode();
            sortedArrayToBST(nums, index1, avg - 1, node.left);
        }
        if (index2 > avg){
            node.right = new TreeNode();
            sortedArrayToBST(nums, avg + 1, index2, node.right);
        }
        return node;
    }
}
