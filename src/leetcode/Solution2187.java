package leetcode;

import java.util.Arrays;

/**
 * 2187. 完成旅途的最少时间
 */
public class Solution2187 {
    public long minimumTime(int[] time, int totalTrips) {
        // 二分查找下界与上界
        long l = 1;
        long r = (long) totalTrips * Arrays.stream(time).max().orElse(0);
        // 二分查找寻找满足要求的最小的 t
        while (l < r) {
            long mid = l + (r - l) / 2;
            if (check(mid, time, totalTrips)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // 判断 t 时间内是否可以完成 totalTrips 趟旅途
    public boolean check(long t, int[] time, int totalTrips) {
        long cnt = 0;
        for (int period : time) {
            cnt += t / period;
        }
        return cnt >= totalTrips;
    }
}
