package leetcode;

import java.util.List;

/**
 * 3350. 检测相邻递增子数组 II
 */
public class Solution3350 {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int ans = 0;
        int preCnt = 0;
        int cnt = 0;
        for (int i = 0; i < nums.size(); i++) {
            cnt++;
            // i 是严格递增段的末尾
            if (i == nums.size() - 1 || nums.get(i) >= nums.get(i + 1)) {
                ans = Math.max(ans, Math.max(cnt / 2, Math.min(preCnt, cnt)));
                preCnt = cnt;
                cnt = 0;
            }
        }
        return ans;
    }
}
