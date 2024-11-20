package leetcode;

import java.util.List;

/**
 * 3248. 矩阵中的蛇
 */
public class Solution3248 {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int ans = 0;
        for (String c : commands) {
            if (c.charAt(0) == 'U') {
                ans -= n;
            } else if (c.charAt(0) == 'D') {
                ans += n;
            } else if (c.charAt(0) == 'L') {
                --ans;
            } else {
                ++ans;
            }
        }
        return ans;
    }
}
