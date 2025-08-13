package leetcode;

/**
 * 1780. 判断一个数字是否可以表示成三的幂的和
 * 思路：转换成三进制，如果有2出现说明有重复的
 * 第二次
 */
public class Solution1780 {
    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
