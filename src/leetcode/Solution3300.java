package leetcode;

/**
 * 3300. 替换为数位和以后的最小元素
 */
public class Solution3300 {
    public int minElement(int[] nums) {
        int ans = 37;
        for (int num : nums) {
            int dig = 0;
            while (num > 0) {
                dig += num % 10;
                num /= 10;
            }
            ans = Math.min(ans, dig);
        }
        return ans;
    }
}
