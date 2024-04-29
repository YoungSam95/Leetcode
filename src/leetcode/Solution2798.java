package leetcode;

/**
 * 2798. 满足目标工作时长的员工数目
 */
public class Solution2798 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] >= target) {
                ans++;
            }
        }
        return ans;
    }
}
