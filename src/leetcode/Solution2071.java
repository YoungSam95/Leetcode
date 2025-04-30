package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 2071. 你可以安排的最多任务数目
 */
public class Solution2071 {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int n = tasks.length, m = workers.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int left = 1, right = Math.min(m, n), ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(tasks, workers, pills, strength, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // 检查是否可以在mid个任务中使用pills和strength
    private boolean check(int[] tasks, int[] workers, int pills, int strength, int mid) {
        int p = pills;
        int m = workers.length;
        Deque<Integer> ws = new ArrayDeque<>();
        int ptr = m - 1;
        // 从大到小枚举每一个任务
        for (int i = mid - 1; i >= 0; --i) {
            while (ptr >= m - mid && workers[ptr] + strength >= tasks[i]) {
                ws.addFirst(workers[ptr]);
                --ptr;
            }
            if (ws.isEmpty()) {
                return false;
            } else if (ws.getLast() >= tasks[i]) {
                // 如果双端队列中最大的元素大于等于 tasks[i]
                ws.pollLast();
            } else {
                if (p == 0) {
                    return false;
                }
                --p;
                ws.pollFirst();
            }
        }
        return true;
    }
}
