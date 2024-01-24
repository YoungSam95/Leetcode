package leetcode;

import java.util.List;

/**
 * 2859. 计算 K 置位下标对应元素的和
 */
public class Solution2859 {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (bitCount(i) == k) {
                ans += nums.get(i);
            }
        }
        return ans;
    }

    public int bitCount(int x) {
        int cnt = 0;
        while (x != 0) {
            cnt += (x % 2);
            x /= 2;
        }
        return cnt;
    }
}
