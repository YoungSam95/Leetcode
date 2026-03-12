package leetcode;

/**
 * 3296. 移山所需的最少秒数
 */
public class Solution3296 {
    private static final double EPS = 1e-7;

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int maxWorkerTimes = 0;
        for (int t : workerTimes) {
            maxWorkerTimes = Math.max(maxWorkerTimes, t);
        }

        long l = 1;
        long r = (long) maxWorkerTimes * mountainHeight * (mountainHeight + 1) / 2;
        long ans = 0;

        while (l <= r) {
            long mid = (l + r) / 2;
            long cnt = 0;
            for (int t : workerTimes) {
                long work = mid / t;
                // 求最大的 k 满足 1+2+...+k <= work
                long k = (long)((-1.0 + Math.sqrt(1 + work * 8)) / 2 + EPS);
                cnt += k;
            }

            if (cnt >= mountainHeight) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}
