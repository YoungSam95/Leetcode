package leetcode;

/**
 * 2904. 最短且字典序最小的美丽子字符串
 */
public class Solution2904 {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        for (int m = k; m <= n; m++) {
            String ans = "";
            for (int i = m; i <= n; i++) {
                String t = s.substring(i - m, i);
                int cnt = 0;
                for (int j = 0; j < t.length(); j++) {
                    cnt += t.charAt(j) - '0';
                }
                if ((ans.isEmpty() || t.compareTo(ans) < 0) && cnt == k) {
                    ans = t;
                }
            }
            if (!ans.isEmpty()) {
                return ans;
            }
        }
        return "";
    }
}
