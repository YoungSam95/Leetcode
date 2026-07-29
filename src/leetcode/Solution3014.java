package leetcode;

/**
 * 3014. 输入单词需要的最少按键次数 I
 */
public class Solution3014 {
    public int minimumPushes(String word) {
        int n = word.length();
        int m = (n - 1) / 8 + 1;
        return m * (m - 1) * 4 + (n - (m - 1) * 8) * m;
    }
}
