package leetcode;

/**
 * 3096. 得到更多分数的最少关卡数目
 */
public class Solution3096 {
    public int minimumLevels(int[] possible) {
        int n = possible.length;
        int tot = 0;
        for (int x : possible) {
            tot += x == 1 ? 1 : -1;
        }
        int pre = 0;
        for (int i = 0; i < n - 1; i++) {
            pre += possible[i] == 1 ? 1 : -1;
            if (2 * pre > tot) {
                return i + 1;
            }
        }
        return -1;
    }
}
