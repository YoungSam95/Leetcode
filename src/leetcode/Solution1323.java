package leetcode;

/**
 * 1323. 6 和 9 组成的最大数字
 */
public class Solution1323 {
    public int maximum69Number (int num) {
        int digitBase = (int)Math.pow(10, (int)Math.log10(num));
        while (digitBase > 0) {
            if ((num / digitBase) % 10 == 6) {
                num += 3 * digitBase;
                return num;
            }
            digitBase /= 10;
        }

        return num;
    }
}
