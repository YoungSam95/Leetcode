package leetcode;

/**
 * 3175. 找到连续赢 K 场比赛的第一位玩家
 */
public class Solution3175 {
    public int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;
        int cnt = 0;
        int i = 0, last_i = 0;

        while (i < n) {
            int j = i + 1;
            while (j < n && skills[j] < skills[i] && cnt < k) {
                j++;
                cnt++;
            }
            if (cnt == k) {
                return i;
            }
            cnt = 1;
            last_i = i;
            i = j;
        }
        return last_i;
    }
}
