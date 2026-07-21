package leetcode;

/**
 * 3513. 不同 XOR 三元组的数目 I
 */
public class Solution3513 {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int ans = 1;
        while (ans <= n) {
            ans <<= 1;
        }
        return ans;
    }
}
