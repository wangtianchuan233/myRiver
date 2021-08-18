package test.exercise.bean;

import exercise.bean.TreeNode;

/**
 * @author wangtianchuan 2021/8/18
 */
public class TreeNodeTest {
    public static void main(String[] args) {
        Integer[] vals = new Integer[]{2,5,3,null,3,2,null,3};
        TreeNode root = new TreeNode(vals);
        System.out.println(root);
    }
}
