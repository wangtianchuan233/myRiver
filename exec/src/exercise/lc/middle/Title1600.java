package exercise.lc.middle;

import java.util.*;

/**
 * @author wangtianchuan
 *
 * 一个王国里住着国王、他的孩子们、他的孙子们等等。每一个时间点，这个家庭里有人出生也有人死亡。
 * ......
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/throne-inheritance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title1600 {
    public static void main(String[] args) {
        List<String> list;
        ThroneInheritance king = new ThroneInheritance("king");
        king.birth("king", "andy"); // 继承顺序：king > andy
        king.birth("king", "bob"); // 继承顺序：king > andy > bob
        king.birth("king", "catherine"); // 继承顺序：king > andy > bob > catherine
        king.birth("andy", "matthew"); // 继承顺序：king > andy > matthew > bob > catherine
        king.birth("bob", "alex"); // 继承顺序：king > andy > matthew > bob > alex > catherine
        king.birth("bob", "asha"); // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
        list = king.getInheritanceOrder(); // 返回 ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
        System.out.println(list);
        king.death("bob"); // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
        list = king.getInheritanceOrder(); // 返回 ["king", "andy", "matthew", "alex", "asha", "catherine"]
        System.out.println(list);
    }
}

class ThroneInheritance {

    private String parent;
    // 用 List 存储, 每次 birth 和 death 都要遍历所有节点, 效率低
    // 改为 hash 存储
    private Map<String, List<String>> treeMap;

    private Set<String> death;

    public ThroneInheritance(String kingName) {
        parent = kingName;
        treeMap = new HashMap<>();
        death = new HashSet<>();
    }

    public void birth(String parentName, String childName) {
        List<String> children = treeMap.getOrDefault(parentName, new ArrayList<>());
        children.add(childName);
        treeMap.put(parentName, children);
    }

    public void death(String name) {
        death.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> list = new ArrayList<>();
        addNameToList(parent, list);
        return list;
    }

    private void addNameToList(String parent, List<String> list) {
        if (!death.contains(parent)){
            list.add(parent);
        }
        final List<String> children = treeMap.getOrDefault(parent, new ArrayList<>());
        for (String child : children) {
            addNameToList(child, list);
        }
    }
}

/*class ThroneInheritance {

    private String parent;
    // 用 List 存储, 每次 birth 和 death 都要遍历所有节点, 效率低
    private List<ThroneInheritance> children;

    public ThroneInheritance(String kingName) {
        parent = kingName;
        children = new ArrayList<>();
    }

    public void birth(String parentName, String childName) {
        if (parent.equals(parentName)){
            children.add(new ThroneInheritance(childName));
        } else {
            for (ThroneInheritance child : children) {
                child.birth(parentName, childName);
            }
        }
    }

    public void death(String name) {
        if (parent.equals(name)){
            parent = "";
        } else {
            for (ThroneInheritance child : children) {
                child.death(name);
            }
        }
    }

    public List<String> getInheritanceOrder() {
        List<String> list = new ArrayList<>();
        addNameToList(this, list);
        return list;
    }

    private void addNameToList(ThroneInheritance member, List<String> list) {
        if (member.parent.length() > 0) {
            list.add(member.parent);
        }
        for (ThroneInheritance child : member.children) {
            addNameToList(child, list);
        }
    }
}*/
