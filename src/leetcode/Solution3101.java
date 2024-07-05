package leetcode;

/**
 * 3101. 交替子数组计数
 */
public class Solution3101 {
    public long countAlternatingSubarrays(int[] nums) {
        long res = 0, cur = 0;
        int pre = -1;
        for (int a : nums) {
            cur = (pre != a) ? cur + 1 : 1;
            pre = a;
            res += cur;
        }
        return res;
    }
}
