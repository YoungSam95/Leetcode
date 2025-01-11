package leetcode;

/**
 * 2275. 按位与结果大于零的最长组合
 */
public class Solution2275 {
    // 计算从低到高第 k 个二进制位数值为 1 的元素个数
    public int maxlen(int[] candidates, int k) {
        int res = 0;
        for (int num : candidates) {
            if ((num & (1 << k)) != 0) {
                res++;
            }
        }
        return res;
    }

    public int largestCombination(int[] candidates) {
        int res = 0;
        for (int i = 0; i < 24; i++) {
            // 遍历二进制位
            res = Math.max(res, maxlen(candidates, i));
        }
        return res;
    }
}
