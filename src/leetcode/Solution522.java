package leetcode;

/**
 * 522. 最长特殊序列 II
 */
public class Solution522 {
    public int findLUSlength(String[] strs) {
        int n = strs.length, ans = -1;
        for(int i = 0; i < n; i++){
            if(strs[i].length() <= ans) continue;
            boolean isSpecial = true;
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(check(strs[i],strs[j])) isSpecial = false;
            }
            if(isSpecial) ans = strs[i].length();
        }
        return ans;
    }

    public boolean check(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (m < n) return false;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? f[i - 1][j - 1] + 1 : f[i - 1][j - 1];
                f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                f[i][j] = Math.max(f[i][j], f[i][j - 1]);
                if (f[i][j] == n) return true;
            }
        }
        return false;
    }
}
