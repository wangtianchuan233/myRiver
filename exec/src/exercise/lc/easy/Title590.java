package exercise.lc.easy;

import exercise.bean.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtianchuan
 * 给定一个 N 叉树，返回其节点值的 后序遍历 。
 *
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 * 进阶：
 * 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * /*
 * // Definition for a Node.
 * class Node {
 *     public int val;
 *     public List<Node> children;
 *
 *     public Node() {}
 *
 *     public Node(int _val) {
 *         val = _val;
 *     }
 *
 *     public Node(int _val, List<Node> _children) {
 *         val = _val;
 *         children = _children;
 *     }
 * };
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title590 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.children = new ArrayList<>();
        root.children.add(new Node(3));
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        root.children.get(0).children = new ArrayList<>();
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));
        System.out.println(new Title590().postorder(root));
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        return root == null ? res : postorder(root, res);
    }
    public List<Integer> postorder(Node root, List<Integer> res){
        if (root.children != null){
            for (Node child : root.children) {
                postorder(child, res);
            }
        }
        res.add(root.val);
        return res;
    }
}
