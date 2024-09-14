package leetcode;

import java.util.List;

/**
 * 2848. 与车相交的点
 */
public class Solution2848 {
    public int numberOfPoints(List<List<Integer>> nums) {
        int C = 0;
        for (List<Integer> interval : nums) {
            C = Math.max(C, interval.get(1));
        }

        int[] count = new int[C + 1];
        for (List<Integer> interval : nums) {
            for (int i = interval.get(0); i <= interval.get(1); ++i) {
                ++count[i];
            }
        }

        int ans = 0;
        for (int i = 1; i <= C; ++i) {
            if (count[i] > 0) {
                ++ans;
            }
        }
        return ans;
    }
}
