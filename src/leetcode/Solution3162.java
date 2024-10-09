package leetcode;

/**
 * 3162. 优质数对的总数 I
 */
public class Solution3162 {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int res = 0;
        for (int a : nums1) {
            for (int b : nums2) {
                if (a % (b * k) == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
