package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2588. 统计美丽子数组数目
 */
public class Solution2588 {
    public long beautifulSubarrays(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int mask = 0;
        long ans = 0;
        cnt.put(0, 1);
        for (int x : nums) {
            mask ^= x;
            ans += cnt.getOrDefault(mask, 0);
            cnt.put(mask, cnt.getOrDefault(mask, 0) + 1);
        }
        return ans;
    }
}
