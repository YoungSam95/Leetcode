package leetcode;

/**
 * 2575. 找出字符串的可整除数组
 */
public class Solution2575 {
    public int[] divisibilityArray(String word, int m) {
        int[] res = new int[word.length()];
        long cur = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            cur = (cur * 10 + (c - '0')) % m;
            res[i] = (cur == 0) ? 1 : 0;
        }
        return res;
    }
}
