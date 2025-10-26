package leetcode;

/**
 * 2125. 银行中的激光束数量
 */
public class Solution2125 {
    public int numberOfBeams(String[] bank) {
        int last = 0, ans = 0;
        for (String line : bank) {
            int cnt = (int) line.chars().filter(ch -> ch == '1').count();
            if (cnt != 0) {
                ans += last * cnt;
                last = cnt;
            }
        }
        return ans;
    }
}
