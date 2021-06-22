package exercise.lc.middle;

import exercise.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wangtianchuan 2021/6/19
 *
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 *
 */
public class Title95 {

    public List<TreeNode> generateTrees(int n) {
        return backTrace(1, n);
    }

    List<TreeNode> backTrace(int start, int end){
        TreeNode root;
        List<TreeNode> treeNodes = new ArrayList<>();
        if (start <= end){
            for(int i = start; i <= end; i++){
                List<TreeNode> leftList = backTrace(start, i - 1);
                List<TreeNode> rightList = backTrace(i + 1, end);
                if (leftList.size() > 0){
                    if (rightList.size() > 0){
                        for (TreeNode l : leftList) {
                            for (TreeNode r : rightList) {
                                root = new TreeNode(i);
                                root.left = l;
                                root.right = r;
                                treeNodes.add(root);
                            }
                        }
                    } else {
                        for (TreeNode l : leftList) {
                            root = new TreeNode(i);
                            root.left = l;
                            treeNodes.add(root);
                        }
                    }
                } else {
                    if (rightList.size() > 0){
                        for (TreeNode r : rightList) {
                            root = new TreeNode(i);
                            root.right = r;
                            treeNodes.add(root);
                        }
                    } else {
                        root = new TreeNode(i);
                        treeNodes.add(root);
                    }
                }
            }
        }
        return treeNodes;
    }

    /**
     * leetcode 的代码, 对空集合添加了一个 null 元素, 减少了遍历时的判断
     */
    public List<TreeNode> generateTrees2(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees2(1, n);
    }

    public List<TreeNode> generateTrees2(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees2(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees2(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }

}
