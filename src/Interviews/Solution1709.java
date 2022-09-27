package Interviews;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 面试题 17.09. 第 k 个数
 */
public class Solution1709 {
    public int getKthMagicNumber(int k) {
        int[] factors = {3,5,7};
        Set<Long> check = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        check.add(1L);
        heap.offer(1L);
        int res = 0;
        for(int i = 0; i < k; i++){
            long curr = heap.poll();
            res = (int)curr;
            for(int factor : factors) {
                long next = curr * factor;
                if (check.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return res;
    }
    public int getKthMagicNumber2(int k) {
        int[] dp = new int[k + 1];
        dp[1] = 1;
        int p3 = 1, p5 = 1, p7 = 1;
        for (int i = 2; i <= k; i++) {
            int num3 = dp[p3] * 3, num5 = dp[p5] * 5, num7 = dp[p7] * 7;
            dp[i] = Math.min(Math.min(num3, num5), num7);
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
            if (dp[i] == num7) {
                p7++;
            }
        }
        return dp[k];
    }
}
