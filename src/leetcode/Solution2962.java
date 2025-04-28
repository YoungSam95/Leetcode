package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2962. 统计最大元素出现至少 K 次的子数组
 */
public class Solution2962 {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int mx = Arrays.stream(nums).max().getAsInt();
        List<Integer> pos = new ArrayList<>();
        pos.add(-1);
        for (int i = 0; i < n; i++) {
            if (nums[i] == mx) {
                pos.add(i);
            }
        }
        int left = 1, right = k;
        long ans = 0;
        while (right < pos.size()) {
            ans += (long)(pos.get(left) - pos.get(left - 1)) * (n - pos.get(right));
            left++;
            right++;
        }
        return ans;
    }
}
