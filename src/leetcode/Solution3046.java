package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3046. 分割数组
 */
public class Solution3046 {
    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (count.get(num) > 2) {
                return false;
            }
        }
        return true;
    }
}
