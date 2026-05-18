package leetcode;

import java.util.HashSet;

/**
 * 2540. 最小公共值
 */
public class Solution2540 {
    public int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new java.util.HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                return num;
            }
        }
        return -1;
    }
}
