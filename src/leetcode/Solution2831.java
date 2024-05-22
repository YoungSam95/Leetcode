package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2831. 找出最长等值子数组
 */
public class Solution2831 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.computeIfAbsent(nums.get(i), x -> new ArrayList<>()).add(i);
        }
        int ans = 0;
        for (List<Integer> vec : pos.values()) {
            for (int i = 0, j = 0; i < vec.size(); i++) {
                /* 缩小窗口，直到不同元素数量小于等于 k */
                while (vec.get(i) - vec.get(j) - (i - j) > k) {
                    j++;
                }
                ans = Math.max(ans, i - j + 1);
            }
        }
        return ans;
    }
}
