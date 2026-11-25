package leetcode;

/**
 * 3360. 移除石头游戏
 */
public class Solution3360 {
    public boolean canAliceWin(int n) {
        int take = 10, k = 0;
        while (n >= take) {
            n -= take;
            take--;
            k++;
        }
        return k % 2 == 1;
    }
}
