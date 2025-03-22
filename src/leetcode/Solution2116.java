package leetcode;

/**
 * 2116. 判断一个括号字符串是否有效
 */
public class Solution2116 {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        int mx = 0;   // 可以达到的最大分数
        int mn = 0;   // 可以达到的最小分数 与 最小有效前缀对应分数 的较大值
        for (int i = 0; i < n; ++i) {
            if (locked.charAt(i) == '1') {
                // 此时对应字符无法更改
                int diff;
                if (s.charAt(i) == '(') {
                    diff = 1;
                } else {
                    diff = -1;
                }
                mx += diff;
                mn = Math.max(mn + diff, (i + 1) % 2);
            } else {
                // 此时对应字符可以更改
                ++mx;
                mn = Math.max(mn - 1, (i + 1) % 2);
            }
            if (mx < mn) {
                // 此时该前缀无法变为有效前缀
                return false;
            }
        }
        // 最终确定 s 能否通过变换使得分数为 0（成为有效字符串）
        return mn == 0;
    }
}
