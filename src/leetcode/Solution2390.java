package leetcode;

/**
 * 2390. 从字符串中移除星号
 */
public class Solution2390 {
    public String removeStars(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '*') {
                res.append(c);
            } else {
                res.setLength(res.length() - 1);
            }
        }
        return res.toString();
    }
}
