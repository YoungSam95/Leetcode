package leetcode;

/**
 * 3222. 求出硬币游戏的赢家
 */
public class Solution3222 {
    public String losingPlayer(int x, int y) {
        return Math.min(x, y / 4) % 2 == 0 ? "Bob" : "Alice";
    }
}
