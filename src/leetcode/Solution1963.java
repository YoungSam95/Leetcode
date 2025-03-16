package leetcode;

/**
 * 1963. 使字符串平衡的最小交换次数
 */
public class Solution1963 {
    public int minSwaps(String s) {
        int cnt = 0, mincnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                cnt += 1;
            } else {
                cnt -= 1;
                mincnt = Math.min(mincnt, cnt);
            }
        }
        return (-mincnt + 1) / 2;
    }
}
