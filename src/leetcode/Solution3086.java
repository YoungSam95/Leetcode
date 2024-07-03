package leetcode;

/**
 * 3086. 拾起 K 个 1 需要的最少行动次数
 */
public class Solution3086 {
    public long minimumMoves(int[] nums, int k, int maxChanges) {
        int n = nums.length;

        int left = 0, right = -1;
        long leftSum = 0, rightSum = 0;
        long leftCount = 0, rightCount = 0;
        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (f(i, nums) + maxChanges >= k) {
                if (k <= f(i, nums)) {
                    res = Math.min(res, (long)k - nums[i]);
                } else {
                    res = Math.min(res, (long)2 * k - f(i, nums) - nums[i]);
                }
            }
            if (k <= maxChanges) {
                continue;
            }
            while (right + 1 < n && (right - i < i - left || leftCount + rightCount + maxChanges < k)) {
                if (nums[right + 1] == 1) {
                    rightCount++;
                    rightSum += right + 1;
                }
                right++;
            }
            while (leftCount + rightCount + maxChanges > k) {
                if (right - i < i - left || right - i == i - left && nums[left] == 1) {
                    if (nums[left] == 1) {
                        leftCount--;
                        leftSum -= left;
                    }
                    left++;
                } else {
                    if (nums[right] == 1) {
                        rightCount--;
                        rightSum -= right;
                    }
                    right--;
                }
            }
            res = Math.min(res, leftCount * i - leftSum + rightSum - rightCount * i + 2 * maxChanges);
            if (nums[i] == 1) {
                leftCount++;
                leftSum += i;
                rightCount--;
                rightSum -= i;
            }
        }
        return res;
    }

    public int f(int i, int[] nums) {
        int x = nums[i];
        if (i - 1 >= 0) {
            x += nums[i - 1];
        }
        if (i + 1 < nums.length) {
            x += nums[i + 1];
        }
        return x;
    }
}
