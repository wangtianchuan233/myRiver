package exercise.lc.easy;

import exercise.bean.Node;

import java.util.ArrayList;
import java.util.List;

/*
 * @author wangtianchuan
 * 给定一个 N 叉树，返回其节点值的 前序遍历.
 *
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 * 进阶：
 *
 * 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Definition for a Node.
 *  class Node {
 *      public int val;
 *      public List<Node> children;
 *
 *      public Node() {}
 *
 *      public Node(int _val) {
 *          val = _val;
 *      }
 *
 *      public Node(int _val, List<Node> _children) {
 *          val = _val;
 *          children = _children;
 *      }
 *  };
*/


public class Title589 {
    public static void main(String[] args) {

    }

    /*
    递归法解决
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    public void preorder(Node root, List<Integer> list) {
        if (root == null) return;

        list.add(root.val);
        for (Node child : root.children) {
            preorder(child, list);
        }
    }

    /*
    迭代法解决 TODO
     */
    public List<Integer> preorder2(Node root) {

        List<Integer> list = new ArrayList<>();
        List<Node> queue = new ArrayList<>();

        Node dummyNode = new Node(-1);
        List<Node> children = new ArrayList<>();
        children.add(root);
        dummyNode.children = children;

        root = dummyNode;


        while (root != null ){
            queue.add(root);
            while (root.children != null){

            }
        }

        return null;
    }
}
