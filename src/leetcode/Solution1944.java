package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1944. 队列中可以看到的人数
 */
public class Solution1944 {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int h = heights[i];
            while (!stack.isEmpty() && stack.peek() < h) {
                stack.pop();
                res[i]++;
            }
            if (!stack.isEmpty()) {
                res[i]++;
            }
            stack.push(h);
        }
        return res;
    }
}
