package leetcode;

/**
 * 829. 连续整数求和
 */
public class Solution829 {
    // 将 n 表示成 k 个连续的正整数之和。
    // 设第一个数为x，连续的k个数之和为x+(x+1)+ ... + (x+k-1) = k * x + (1+2+...+k-1) = k * x + k(k-1)/2。
    // 能表示的条件为n=k * x + k(k-1)/2 (x≥1,k≥1), 即 (n−sum) mod k = 0。
    public int consecutiveNumbersSum(int n) {
        int sum = 0, ans = 0;
        for (int i = 1; sum < n; i++) {
            if ((n - sum) % i == 0) ans++;
            sum += i;
        }
        return ans;
    }
}
