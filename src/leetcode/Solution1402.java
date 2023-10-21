package leetcode;

import java.util.Arrays;

/**
 * 1402. 做菜顺序
 */
public class Solution1402 {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        for (int i = 0, j = satisfaction.length - 1; i < j; i++, j--) {
            int temp = satisfaction[i];
            satisfaction[i] = satisfaction[j];
            satisfaction[j] = temp;
        }
        int presum = 0, ans = 0;
        for (int si : satisfaction) {
            if (presum + si > 0) {
                presum += si;
                ans += presum;
            } else {
                break;
            }
        }
        return ans;
    }
}
