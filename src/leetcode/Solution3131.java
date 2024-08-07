package leetcode;

import java.util.Arrays;

/**
 * 3131. 找出与数组相加的整数 I
 */
public class Solution3131 {
    public int addedInteger(int[] nums1, int[] nums2) {
        return Arrays.stream(nums2).min().getAsInt() - Arrays.stream(nums1).min().getAsInt();
    }
}
