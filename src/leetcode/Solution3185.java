package leetcode;

/**
 * 3185. 构成整天的下标对数目 II
 */
public class Solution3185 {
    public long countCompleteDayPairs(int[] hours) {
        long ans = 0;
        int[] cnt = new int[24];
        for (int hour : hours) {
            ans += cnt[(24 - hour % 24) % 24];
            cnt[hour % 24]++;
        }
        return ans;
    }
}
