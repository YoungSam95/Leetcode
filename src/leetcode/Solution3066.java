package leetcode;

import java.util.PriorityQueue;

/**
 * 3066. 超过阈值的最少操作数 II
 */
public class Solution3066 {
    public int minOperations(int[] nums, int k) {
        int res = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long num : nums) {
            pq.offer(num);
        }
        while (pq.peek() < k) {
            long x = pq.poll(), y = pq.poll();
            pq.offer(x + x + y);
            res++;
        }
        return res;
    }
}
