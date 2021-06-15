package exercise.bean;

/**
 * @author wangtianchuan
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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

    public TreeNode(Integer[] array){

    }

    public int height(int len){
        int height = 0;
        int rowSize = 1;
        while (len >= rowSize){
            height++;
            len -= rowSize;
            rowSize = rowSize << 1;
        }
        return height;
    }
}
