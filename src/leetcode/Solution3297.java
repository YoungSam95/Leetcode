package leetcode;

/**
 * 3297. 统计重新排列后包含另一个字符串的子字符串数目 I
 */
public class Solution3297 {
    public long validSubstringCount(String word1, String word2) {
        int[] count = new int[26];
        for (char c : word2.toCharArray()) {
            count[c - 'a']++;
        }
        int n = word1.length();
        int[][] preCount = new int[n + 1][26];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 26; j++) {
                preCount[i][j] = preCount[i - 1][j];
            }
            preCount[i][word1.charAt(i - 1) - 'a']++;
        }
        long res = 0;
        for (int l = 1; l <= n; l++) {
            int r = get(l, n + 1, preCount, count);
            res += n - r + 1;
        }
        return res;
    }

    private int get(int l, int r, int[][] preCount, int[] count) {
        int border = l;
        while (l < r) {
            int m = (l + r) >> 1;
            boolean f = true;
            for (int i = 0; i < 26; i++) {
                if (preCount[m][i] - preCount[border - 1][i] < count[i]) {
                    f = false;
                    break;
                }
            }
            if (f) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
