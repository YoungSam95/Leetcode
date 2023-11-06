package leetcode;

/**
 * 2586. 统计范围内的元音字符串数
 */
public class Solution2586 {
    private static final String VOWEL = "aeiou";

    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            String s = words[i];
            if (VOWEL.indexOf(s.charAt(0)) != -1 &&
                    VOWEL.indexOf(s.charAt(s.length() - 1)) != -1) {
                ans++;
            }
        }
        return ans;
    }
}
