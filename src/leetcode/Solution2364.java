package leetcode;

import java.util.HashMap;

/**
 * 2364. 统计坏数对的数目
 */
public class Solution2364 {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] - i;
            res += i - mp.getOrDefault(key, 0);
            mp.put(key, mp.getOrDefault(key, 0) + 1);
        }
        return res;
    }
}
