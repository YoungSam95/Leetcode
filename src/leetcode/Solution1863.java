package leetcode;

/**
 * 1863. 找出所有子集的异或总和再求和
 */
public class Solution1863 {
    int res;
    int n;

    // 深度优先搜索
    void dfs(int val, int idx, int[] nums) {
        if (idx == n) {
            // 终止递归
            res += val;
            return;
        }
        // 考虑选择当前数字
        dfs(val ^ nums[idx], idx + 1, nums);
        // 考虑不选择当前数字
        dfs(val, idx + 1, nums);
    }

    public int subsetXORSum(int[] nums) {
        res = 0;
        n = nums.length;
        dfs(0, 0, nums);
        return res;
    }
}
