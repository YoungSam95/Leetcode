package leetcode;

/**
 * 1870. 准时到达的列车最小时速
 */
public class Solution1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        // 将 hour 乘 100 以转为整数
        long hr = Math.round(hour * 100);
        // 时间必须要大于路程段数减 1
        if (hr <= (n - 1) * 100) {
            return -1;
        }
        // 二分
        int l = 1;
        int r = 10000000;
        while (l < r) {
            int mid = l + (r - l) / 2;
            // 判断当前时速是否满足时限
            long t = 0;
            // 前 n-1 段中第 i 段贡献的时间： floor(dist[i] / mid)
            for (int i = 0; i < n - 1; ++i) {
                t += (dist[i] - 1) / mid + 1;
            }
            // 最后一段贡献的时间： dist[n-1] / mid
            t *= mid;
            t += dist[n - 1];
            if (t * 100 <= hr * mid) { // 通分以转化为整数比较
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l; // 满足条件的最小时速
    }
}
