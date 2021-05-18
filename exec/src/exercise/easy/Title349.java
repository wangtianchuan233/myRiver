package exercise.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wangtianchuan
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title349 {

    public static void main(String[] args) {
        int[] m = {1,2,2,1};
        int[] n = {2,2};
        System.out.println(Arrays.toString(new Title349().intersection2(m,n)));
    }

    /*
        3ms, 83.96%
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        Set<Integer> set = new HashSet<>();
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] == nums2[j]){
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]){
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (Integer e : set) {
            res[index++] = e;
        }
        return res;
    }

    /*
        4ms, 35.29%
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        final Set<Integer> collect = set1.stream().filter(x -> set2.contains(x)).collect(Collectors.toSet());
        int[] res = new int[collect.size()];
        int i = 0;
        for (Integer integer : collect) {
            res[i++] = integer;
        }
        return res;
    }

    /*
        3ms, 83.96%
     */
    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)){
                set2.add(i);
            }
        }
        int[] res = new int[set2.size()];
        int i = 0;
        for (Integer integer : set2) {
            res[i++] = integer;
        }
        return res;
    }
}
