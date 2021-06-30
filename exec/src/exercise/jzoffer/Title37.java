package exercise.jzoffer;

import exercise.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtianchuan
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title37 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(4);
        right.right = new TreeNode(5);
        final Codec t = new Codec();
        TreeNode x = t.deserialize(t.serialize(root));
        System.out.println(x);
    }
}

/**
 * 这道题转 类json 和解析 类json 的方式很慢, 本意是考察二叉树的遍历
 */
// 163 ms, 5%
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        TreeNode dummyNode = new TreeNode(-1);
        dummyNode.right = root;
        serialize(dummyNode, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append("null");
        }
        if (root != null){
            sb.append("{");
            sb.append("val:");
            sb.append(root.val);
            sb.append(",");
            sb.append("left:");
            serialize(root.left, sb);
            sb.append(",");
            sb.append("right:");
            serialize(root.right, sb);
            sb.append(",");
            sb.append("}");
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return parseJson(data).right;
    }

    private TreeNode parseJson(String data) {
        TreeNode tree = null;
        try {
            if ("null".equals(data)){
                return null;
            }
            String[] kvs = splitToKvs(data.toCharArray());
            tree = new TreeNode();
            for (String kv : kvs) {
                final String[] k0v1 = parseKV(kv);
                if ("val".equals(k0v1[0])) {
                    tree.val = Integer.parseInt(k0v1[1]);
                } else if ("left".equals(k0v1[0])){
                    tree.left = parseJson(k0v1[1]);
                } else {
                    tree.right = parseJson(k0v1[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tree;
    }

    private String[] splitToKvs(char[] chars) {
        List<String> list = new ArrayList<>();
        int a = 0;
        int countLeft = 0;
        for(int i = 1; i < chars.length - 1; i++){
            if (a == 0){
                a = i;
            }
            if (countLeft == 0 && chars[i] == ','){
                list.add(new String(chars, a, i - a));
                a = 0;
            }
            if (chars[i] == '{'){
                countLeft++;
            } else if (chars[i] == '}'){
                countLeft--;
            }
        }
        String[] res = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    private String[] parseKV(String kv){
        int i = kv.indexOf(":");
        String[] res = new String[2];
        res[0] = kv.substring(0, i);
        res[1] = kv.substring(i + 1);
        /*if (res[0].indexOf("\"") > 0){
            res[0] = res[0].substring(1, res[0].length() - 1);
        }*/
        return res;
    }
}

// 力扣不支持反射, 搞不出来;

/*class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        TreeNode dummyNode = new TreeNode(-1);
        dummyNode.right = root;
        serialize(dummyNode, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append("null");
        }
        if (root != null){
            sb.append("{");
            sb.append("val:");
            sb.append(root.val);
            sb.append(",");
            sb.append("left:");
            serialize(root.left, sb);
            sb.append(",");
            sb.append("right:");
            serialize(root.right, sb);
            sb.append(",");
            sb.append("}");
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return parseJson(data).right;
    }

    private TreeNode parseJson(String data) {
        Object obj = null;
        try {
            if ("null".equals(data)){
                return null;
            }
            String[] kvs = splitToKvs(data.toCharArray());
            //Class<?> treeNodeClass = Class.forName("exercise.bean.TreeNode");
            Class<?> treeNodeClass = TreeNode.class;
            obj = treeNodeClass.newInstance();
            for (String kv : kvs) {
                final String[] k0v1 = parseKV(kv);
                final Field field = treeNodeClass.getDeclaredField(k0v1[0]);
                field.setAccessible(true);
                if ("val".equals(field.getName())) {
                    field.set(obj, Integer.parseInt(k0v1[1]));
                } else {
                    field.set(obj, parseJson(k0v1[1]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (TreeNode)obj;
    }

    private String[] splitToKvs(char[] chars) {
        List<String> list = new ArrayList<>();
        int a = 0;
        int countLeft = 0;
        for(int i = 1; i < chars.length - 1; i++){
            if (a == 0){
                a = i;
            }
            if (countLeft == 0 && chars[i] == ','){
                list.add(new String(chars, a, i - a));
                a = 0;
            }
            if (chars[i] == '{'){
                countLeft++;
            } else if (chars[i] == '}'){
                countLeft--;
            }
        }
        String[] res = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    private String[] parseKV(String kv){
        int i = kv.indexOf(":");
        String[] res = new String[2];
        res[0] = kv.substring(0, i);
        res[1] = kv.substring(i + 1);
        *//*if (res[0].indexOf("\"") > 0){
            res[0] = res[0].substring(1, res[0].length() - 1);
        }*//*
        return res;
    }
}*/
