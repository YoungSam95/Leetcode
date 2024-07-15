package leetcode;

import java.util.HashSet;

/**
 * 2956. 找到两个数组中的公共元素
 */
public class Solution2956 {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        HashSet<Integer> s1 = new HashSet<>();
        for (int x : nums1) {
            s1.add(x);
        }
        HashSet<Integer> s2 = new HashSet<>();
        for (int x : nums2) {
            s2.add(x);
        }

        int[] res = new int[2];
        for (int x : nums1) {
            if (s2.contains(x)) {
                res[0]++;
            }
        }
        for (int x : nums2) {
            if (s1.contains(x)) {
                res[1]++;
            }
        }
        return res;
    }
}
