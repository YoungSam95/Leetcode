package leetcode;

import java.util.*;

/**
 * 2808. 使循环数组所有元素相等的最少秒数
 */
public class Solution2808 {
    public int minimumSeconds(List<Integer> nums) {
        HashMap<Integer, List<Integer>> mp = new HashMap<>();
        int n = nums.size(), res = n;
        for (int i = 0; i < n; ++i) {
            mp.computeIfAbsent(nums.get(i), k -> new ArrayList<>()).add(i);
        }
        for (List<Integer> positions : mp.values()) {
            int mx = positions.get(0) + n - positions.get(positions.size() - 1);
            for (int i = 1; i < positions.size(); ++i) {
                mx = Math.max(mx, positions.get(i) - positions.get(i - 1));
            }
            res = Math.min(res, mx / 2);
        }
        return res;
    }
}
