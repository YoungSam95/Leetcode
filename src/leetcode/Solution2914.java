package leetcode;

/**
 * 2914. 使二进制字符串变美丽的最少修改次数
 */
public class Solution2914 {
    public int minChanges(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                ans++;
            }
        }
        return ans;
    }
}
