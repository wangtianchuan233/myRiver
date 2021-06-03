package exercise.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangtianchuan
 * 
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 * 
 *
 * 示例 1:
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 *
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 * 
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Title525 {

    public static void main(String[] args) {

    }

    /**
     * 官方答案
     *
     * 由于「0 和 1 的数量相同」等价于「1 的数量减去 0 的数量等于 0」，我们可以将数组中的 0 视作 -1，
     * 则原问题转换成「求最长的连续子数组，其元素和为 0」。
     *
     * 设数组 nums 的长度为 n，将数组 nums 进行转换得到长度相等的新数组 newNums：对于 0 ≤ i < n，
     * 当 nums[i]=1 时 newNums[i]=1，当 nums[i]=0 时 newNums[i]=−1。
     *
     * 为了快速计算 newNums 的子数组的元素和，需要首先计算 newNums 的前缀和。用 prefixSums[i] 表示 newNums 
     * 从下标 0 到下标 i 的前缀和，则 newNums 从下标 j+1 到下标 k（其中 j<k）的子数组的元素和为
     * prefixSums[k]−prefixSums[j]，该子数组的长度为 k-j。
     *
     * 当 prefixSums[k]−prefixSums[j]=0 时，即得到 newNums 的一个长度为 k-j 的子数组元素和为 0，
     * 对应 nums 的一个长度为 k-j 的子数组中有相同数量的 0 和 1。
     *
     * 实现方面，不需要创建数组 newNums 和 prefixSums，只需要维护一个变量 counter 存储 newNums 的前缀和即可。
     * 具体做法是，遍历数组 nums，当遇到元素 1 时将 counter 的值加 1，当遇到元素 0 时将 counter 的值减 1，
     * 遍历过程中使用哈希表存储每个前缀和第一次出现的下标。
     *
     * 规定空的前缀的结束下标为 -1，由于空的前缀的元素和为 0，因此在遍历之前，
     * 首先在哈希表中存入键值对 (0,−1)。遍历过程中，对于每个下标 i，进行如下操作：
     *
     * 如果 counter 的值在哈希表中已经存在，则取出 counter 在哈希表中对应的下标 prevIndex，
     * nums 从下标 prevIndex+1 到下标 i 的子数组中有相同数量的 0 和 1，该子数组的长度为 i−prevIndex，
     * 使用该子数组的长度更新最长连续子数组的长度；
     *
     * 如果 counter 的值在哈希表中不存在，则将当前余数和当前下标 i 的键值对存入哈希表中。
     *
     * 由于哈希表存储的是 counter 的每个取值第一次出现的下标，因此当遇到重复的前缀和时，
     * 根据当前下标和哈希表中存储的下标计算得到的子数组长度是以当前下标结尾的子数组中满足有相同数量的 0 和 1 的最长子数组的长度。
     * 遍历结束时，即可得到 nums 中的有相同数量的 0 和 1 的最长子数组的长度。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/contiguous-array/solution/lian-xu-shu-zu-by-leetcode-solution-mvnm/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i] == 1 ? 1 : -1;
            final Integer len = map.get(sum);
            if (len == null) {
                map.put(sum, i);
            } else {
                maxLen = Math.max((i - len), maxLen);
            }
        }
        return maxLen;
    }
}
