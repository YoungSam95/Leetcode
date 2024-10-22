package leetcode;

/**
 * 3184. 构成整天的下标对数目 I
 */
public class Solution3184 {
    public int countCompleteDayPairs(int[] hours) {
        int ans = 0;
        for (int i = 1; i < hours.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
