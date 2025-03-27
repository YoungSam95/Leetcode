package leetcode;

/**
 * 2716. 最小化字符串长度
 */
public class Solution2716 {
    public int minimizedStringLength(String s) {
        int mask = 0;
        for (Character c : s.toCharArray()) {
            mask |= 1 << (c - 'a');
        }
        return Integer.bitCount(mask);
    }
}
