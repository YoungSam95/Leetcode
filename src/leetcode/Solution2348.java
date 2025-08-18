package leetcode;

/**
 * 2348. 全 0 子数组的数目
 */
public class Solution2348 {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0L;
        long c = 0;
        for (int num : nums)
            if (num != 0) c = 0;
            else ans += ++c;
        return ans;
    }
}
