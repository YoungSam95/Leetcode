package leetcode;

/**
 * 1295. 统计位数为偶数的数字
 */
public class Solution1295 {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
