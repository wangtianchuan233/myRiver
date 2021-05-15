package exercise.util;

/**
 * @author wangtianchuan
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    private void printNode(TreeNode node){
        if (node.left != null){
            printNode(node.left);
        }
        System.out.print(node.val + ",");
        if (node.right != null){
            printNode(node.right);
        }
    }
}
