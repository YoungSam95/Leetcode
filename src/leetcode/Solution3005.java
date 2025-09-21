package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3005. 最大频率元素计数
 */
public class Solution3005 {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : nums) {
            count.put(a, count.getOrDefault(a, 0) + 1);
        }
        int maxf = 0;
        for (int value : count.values()) {
            if (value > maxf) {
                maxf = value;
            }
        }
        int res = 0;
        for (int value : count.values()) {
            if (value == maxf) {
                res += maxf;
            }
        }
        return res;
    }
}
