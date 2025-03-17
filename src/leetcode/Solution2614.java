package leetcode;

/**
 * 2614. 对角线上的质数
 */
public class Solution2614 {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length, res = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(nums[i][i])) {
                res = Math.max(res, nums[i][i]);
            }
            if (isPrime(nums[i][n - i - 1])) {
                res = Math.max(res, nums[i][n - i - 1]);
            }
        }
        return res;
    }

    private boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        int factor = 2;
        while (factor * factor <= num) {
            if (num % factor == 0) {
                return false;
            }
            factor++;
        }
        return true;
    }
}
