package leetcode;

/**
 * 3876. 构造奇偶一致的数组 II
 */
public class Solution3876 {
    public boolean uniformArray(int[] nums1) {
        int mn = nums1[0];
        boolean hasOdd = false;
        for (int v : nums1) {
            if (v < mn) {
                mn = v;
            }
            if ((v & 1) == 1) {
                hasOdd = true;
            }
        }
        if ((mn & 1) == 1) {
            return true;
        }
        return !hasOdd;
    }
}
