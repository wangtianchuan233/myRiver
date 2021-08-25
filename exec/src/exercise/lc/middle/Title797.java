package exercise.lc.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtianchuan 2021/8/25
 */
public class Title797 {

    public static void main(String[] args) {
        Title797 t = new Title797();
        int[][] graph = {{1,2},{3},{3},{}};
        System.out.println(t.allPathsSourceTarget(graph));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> way = new ArrayList<>();
        way.add(0);
        dfs(ans, graph, way, graph.length - 1, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[][] graph, ArrayList<Integer> way, int target, int cur) {
        if (cur == target) {
            ans.add(new ArrayList<>(way));
        }
        if (graph[cur].length == 0){
            return;
        }
        for (int next : graph[cur]) {
            way.add(next);
            dfs(ans, graph, way, target, next);
            way.remove(way.size() - 1);
        }
    }
}
