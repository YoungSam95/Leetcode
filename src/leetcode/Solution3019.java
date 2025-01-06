package leetcode;

/**
 * 3019. 按键变更的次数
 */
public class Solution3019 {
    public int countKeyChanges(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (Character.toLowerCase(s.charAt(i - 1)) != Character.toLowerCase(s.charAt(i))) {
                ++ans;
            }
        }
        return ans;
    }
}
