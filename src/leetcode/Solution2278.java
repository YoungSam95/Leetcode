package leetcode;

/**
 * 2278. 字母在字符串中的百分比
 */
public class Solution2278 {
    public int percentageLetter(String s, char letter) {
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) cnts[c - 'a']++;
        int sum = 0;
        for (int i = 0; i < 26; i++) sum += cnts[i];
        return 100 * cnts[letter - 'a'] / sum;
    }
}
