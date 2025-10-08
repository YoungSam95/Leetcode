package leetcode;

/**
 * 3494. 酿造药水需要的最少总时间
 */
public class Solution3494 {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long[] times = new long[n];

        for (int j = 0; j < m; j++) {
            long curTime = 0;
            for (int i = 0; i < n; i++) {
                curTime = Math.max(curTime, times[i]) + (long)skill[i] * mana[j];
            }
            times[n - 1] = curTime;
            for (int i = n - 2; i >= 0; i--) {
                times[i] = times[i + 1] - (long)skill[i + 1] * mana[j];
            }
        }
        return times[n - 1];
    }
}
