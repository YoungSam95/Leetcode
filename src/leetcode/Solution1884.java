package leetcode;

/**
 * 1884. 鸡蛋掉落-两枚鸡蛋
 */
public class Solution1884 {
    public int twoEggDrop(int n) {
        return (int) Math.ceil((-1 + Math.sqrt(1 + 8 * n)) / 2);
    }
}
