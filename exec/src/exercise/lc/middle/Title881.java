package exercise.lc.middle;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author wangtianchuan 2021/8/26
 * 
 * 第i个人的体重为people[i]，每艘船可以承载的最大重量为limit。
 *
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为limit。
 *
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/boats-to-save-people
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title881 {
    public static void main(String[] args) {
        Title881 t = new Title881();
        int[] p = {3,2,3,2,2};
        int l = 6;
        System.out.println(t.numRescueBoats(p, l));
    }

    /**
     * 要使需要的船数尽可能地少，应当使载两人的船尽可能地多。
     *
     * 设 people 的长度为 n。考虑体重最轻的人：
     *
     * 若他不能与体重最重的人同乘一艘船，那么体重最重的人无法与任何人同乘一艘船，
     * 此时应单独分配一艘船给体重最重的人。
     * 从 people 中去掉体重最重的人后，
     * 我们缩小了问题的规模，变成求解剩余 n−1 个人所需的最小船数，将其加一即为原问题的答案。
     * 若他能与体重最重的人同乘一艘船，那么他能与其余任何人同乘一艘船，
     * 为了尽可能地利用船的承载重量，选择与体重最重的人同乘一艘船是最优的。
     * 从 people 中去掉体重最轻和体重最重的人后，
     * 我们缩小了问题的规模，变成求解剩余 n−2 个人所需的最小船数，将其加一即为原问题的答案。
     * 在代码实现时，我们可以先对 people 排序，
     * 然后用两个指针分别指向体重最轻和体重最重的人，按照上述规则来移动指针，并统计答案。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/boats-to-save-people/solution/jiu-sheng-ting-by-leetcode-solution-0nsp/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int numRescueBoats2(int[] people, int limit) {
        int l = 0, r = people.length - 1;
        int boat = 0;
        Arrays.sort(people);
        while (l < r){
            if (people[l] + people[r] <= limit) {
                l++;
            }
            r--;
            boat++;
        }
        if (l == r){
            boat++;
        }
        return boat;
    }
    /**
     * chao shi le
     */
    public int numRescueBoats(int[] people, int limit) {
        PriorityQueue<Integer> leftRoom = new PriorityQueue<>();
        Arrays.sort(people);
        int halfLimit = limit >> 1;
        int boat = 0;
        for(int i = people.length - 1; i >= 0; i--){
            if (people[i] > halfLimit){
                boat ++;
                if (limit > people[i]){
                    leftRoom.offer(limit - people[i]);
                }
            } else {
                boolean a = false;
                for (Iterator<Integer> iterator = leftRoom.iterator(); iterator.hasNext(); ) {
                    Integer next = iterator.next();
                    if (next >= people[i]){
                        iterator.remove();
                        a = true;
                        break;
                    }
                }
                if (!a) {
                    boat++;
                    leftRoom.offer(limit - people[i]);
                }
            }
        }
        return boat;
    }
}
