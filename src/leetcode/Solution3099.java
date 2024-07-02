package leetcode;

/**
 * 3099. 哈沙德数
 */
public class Solution3099 {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int s = 0;
        for (int y = x; y != 0; y /= 10) {
            s += y % 10;
        }
        return x % s != 0 ? -1 : s;
    }
}
