package leetcode;

/**
 * 3106. 满足距离约束且字典序最小的字符串
 */
public class Solution3106 {
    public String getSmallestString(String s, int k) {
        char[] ans = s.toCharArray();
        for (int i = 0; i < s.length(); ++i) {
            int dis = Math.min(s.charAt(i) - 'a', 'z' - s.charAt(i) + 1);
            if (dis <= k) {
                ans[i] = 'a';
                k -= dis;
            } else {
                ans[i] -= k;
                break;
            }
        }
        return new String(ans);
    }
}
