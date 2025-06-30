package leetcode;

/**
 * 3330. 找到初始输入字符串 I
 */
public class Solution3330 {
    public int possibleStringCount(String word) {
        int n = word.length(), ans = 1;
        for (int i = 1; i < n; ++i) {
            if (word.charAt(i - 1) == word.charAt(i)) {
                ++ans;
            }
        }
        return ans;
    }
}
