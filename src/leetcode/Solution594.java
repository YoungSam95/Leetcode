package leetcode;

import java.util.HashMap;

/**
 * 594. 最长和谐子序列
 */
public class Solution594 {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap <>();
        int res = 0;
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        for (int key : cnt.keySet()) {
            if (cnt.containsKey(key + 1)) {
                res = Math.max(res, cnt.get(key) + cnt.get(key + 1));
            }
        }
        return res;
    }
}
