package exercise.lc.middle;

import java.util.*;

/**
 * @author wangtianchuan 2021/8/18
 *
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 *
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 *
 * https://leetcode-cn.com/problems/clone-graph/
 *
 */
public class Title133 {

    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }
        // Map<Node, Node> map = new HashMap<>();
        // Node cloned = new Node(node.val);
        // map.put(node, cloned);
        // dfs(node, cloned, map);
        return bfs(node);
    }

    private Node bfs(Node node) {
        if (node == null){
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val, new ArrayList<>()));
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            Node original = q.poll();
            for (Node child : original.neighbors) {
                Node clonedChild = map.get(child);
                if (clonedChild == null) {
                    clonedChild = new Node(child.val, new ArrayList<>());
                    map.put(child, clonedChild);
                    q.offer(child);
                }
                map.get(original).neighbors.add(clonedChild);
            }
        }
        return map.get(node);
    }

    private void dfs(Node original, Node cloned, Map<Node, Node> map) {
        if (cloned.neighbors == null){
            cloned.neighbors = new ArrayList<>();
        }
        for (Node child : original.neighbors) {
            Node clonedChild = map.get(child);
            boolean flag = clonedChild == null;
            if (flag){
                clonedChild = new Node(child.val);
                map.put(child, clonedChild);
            }
            cloned.neighbors.add(clonedChild);
            if (flag){
                dfs(child, clonedChild, map);
            }
        }
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
