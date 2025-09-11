package leetcode;

/**
 * 3227. 字符串元音游戏
 */
public class Solution3227 {
    public boolean doesAliceWin(String s) {
        return s.chars().anyMatch(c -> {return "aeiou".indexOf(c) != -1;});
    }
}
