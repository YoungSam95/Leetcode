package leetcode;

/**
 * 2660. 保龄球游戏的获胜者
 */
public class Solution2660 {
    public int isWinner(int[] player1, int[] player2) {
        int s1 = score(player1);
        int s2 = score(player2);
        return s1 == s2 ? 0 : s1 > s2 ? 1 : 2;
    }

    public int score(int[] player) {
        int res = 0;
        for (int i = 0; i < player.length; i++) {
            if ((i > 0 && player[i - 1] == 10) || (i > 1 && player[i - 2] >= 10)) {
                res += 2 * player[i];
            } else {
                res += player[i];
            }
        }
        return res;
    }
}
