package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 594. 最长和谐子序列
 * <p>
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 * <p>
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 * 说明: 输入的数组长度最大不超过20,000.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 19-7-20 下午8:07
 */
public class LeetCode594 {
    class Solution {
        public int findLHS(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            // 遍历整个Map
            int max = Integer.MIN_VALUE;
            for (int i : map.keySet()) {
                if (map.containsKey(i + 1)) {
                    max = Math.max(map.get(i) + map.get(i + 1), max);
                }
            }
            return max;

        }
    }
}
