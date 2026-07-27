package leetcode;

import java.util.Arrays;

/**
 * 3517. 最小回文排列 I
 */
public class Solution3517 {
    public String smallestPalindrome(String s) {
        int len = s.length();
        int partition = len / 2;

        char[] chars = s.toCharArray();
        Arrays.sort(chars, 0, partition);

        for (int i = 0; i < partition; i++) {
            chars[len - 1 - i] = chars[i];
        }

        return new String(chars);
    }
}
