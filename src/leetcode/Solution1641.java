package leetcode;

import java.util.Arrays;

/**
 *1641. 统计字典序元音字符串的数目
 */
public class Solution1641 {
    //动态规划
    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return Arrays.stream(dp).sum();
    }
    //数学
    public int countVowelStrings2(int n) {
        return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24;
    }
}
