package leetcode;

/**
 * 1526. 形成目标数组的子数组最少增加次数
 */
public class Solution1526 {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int ans = target[0];
        for (int i = 1; i < n; ++i) {
            ans += Math.max(target[i] - target[i - 1], 0);
        }
        return ans;
    }
}
