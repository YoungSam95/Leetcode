package leetcode;

import java.util.Arrays;

/**
 * 3507. 移除最小数对使数组有序 I
 */
public class Solution3507 {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        Arrays.setAll(next, i -> i + 1);
        next[n - 1] = -1;
        int count = 0;

        while (n - count > 1) {
            int curr = 0;
            int target = 0;
            int targetAdjSum = nums[target] + nums[next[target]];
            boolean isAscending = true;

            while (curr != -1 && next[curr] != -1) {
                if (nums[curr] > nums[next[curr]]) {
                    isAscending = false;
                }

                int currAdjSum = nums[curr] + nums[next[curr]];
                if (currAdjSum < targetAdjSum) {
                    target = curr;
                    targetAdjSum = currAdjSum;
                }
                curr = next[curr];
            }

            if (isAscending) {
                break;
            }

            count++;
            next[target] = next[next[target]];
            nums[target] = targetAdjSum;
        }

        return count;
    }
}
