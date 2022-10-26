package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 862. 和至少为 K 的最短子数组
 */
public class Solution862 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for(int i = 0; i < n; i++){
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int res = n + 1;
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i <= n; i++){
            long curSum = preSum[i];
            while(!queue.isEmpty() && curSum - preSum[queue.peekFirst()] >= k){
                res = Math.min(res,i - queue.pollFirst());
            }
            while(!queue.isEmpty() && preSum[queue.peekLast()] >= curSum){
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return res < n + 1 ? res : -1;
    }
}
