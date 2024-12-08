package leetcode;

/**
 * 1812. 判断国际象棋棋盘中一个格子的颜色
 * 第二次
 */
public class Solution1812 {
    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0) - 'a') + (coordinates.charAt(1) - '0')) % 2 == 0;
    }
}
