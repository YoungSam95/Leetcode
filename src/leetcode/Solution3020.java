package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3020. 子集中元素的最大数量
 */
public class Solution3020 {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.merge((long) num, 1, Integer::sum);
        }

        int oneCnt = cnt.getOrDefault(1L, 0);
        // ans 至少是 1 的数量，向下取奇数
        int ans = (oneCnt & 1) == 1 ? oneCnt : oneCnt - 1;

        cnt.remove(1L);

        for (long num : cnt.keySet()) {
            int res = 0;
            long x = num;

            while (cnt.containsKey(x) && cnt.get(x) > 1) {
                res += 2;
                x *= x;
            }

            ans = Math.max(ans, res + (cnt.containsKey(x) ? 1 : -1));
        }

        return ans;
    }
}
