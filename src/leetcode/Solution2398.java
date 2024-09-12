package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2398. 预算内的最多机器人数目
 */
public class Solution2398 {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int res = 0, n = chargeTimes.length;
        long runningCostSum = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0, j = 0; i < n; i++) {
            runningCostSum += runningCosts[i];
            while (!q.isEmpty() && chargeTimes[q.peekLast()] <= chargeTimes[i]) {
                q.pollLast();
            }
            q.addLast(i);
            while (j <= i && (i - j + 1) * runningCostSum + chargeTimes[q.peekFirst()] > budget) {
                if (!q.isEmpty() && q.peekFirst() == j) {
                    q.pollFirst();
                }
                runningCostSum -= runningCosts[j];
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
