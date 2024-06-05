package leetcode;

/**
 * 2938. 区分黑球与白球
 */
public class Solution2938 {
    public long minimumSteps(String s) {
        long ans = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sum++;
            } else {
                ans += sum;
            }
        }
        return ans;
    }
}
