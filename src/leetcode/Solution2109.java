package leetcode;

/**
 * 2109. 向字符串添加空格
 */
public class Solution2109 {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s.length() + spaces.length);
        int preIndex = 0;
        for (int index : spaces) {
            sb.append(s, preIndex, index);
            sb.append(' ');
            preIndex = index;
        }
        sb.append(s, preIndex, s.length());
        return sb.toString();
    }
}
