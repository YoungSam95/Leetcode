package leetcode;

/**
 * 667. 优美的排列 II
 * 思路：
 *   当k=1时，将1-n按照[1,2,⋯,n] 的顺序进行排列，那么相邻的差均为1，满足k=1的要求。
 *   当n-1时，将1-n按照[1,n,2,n−1,3,⋯] 的顺序进行排列，那么相邻的差从n-1开始，依次递减1。这样一来，所有从1到n-1的差值均出现一次，满足k=n-1的要求。
 *   对于其它的一般情况，我们可以将这两种特殊情况进行合并，即列表的前半部分相邻差均为1，后半部分相邻差从k开始逐渐递减到1，这样从1到k的差值均出现一次，对应的列表即为：
 *                                 [1,2,⋯,n−k,n,n−k+1,n−1,n−k+2,⋯]
 */
public class Solution667 {
    public int[] constructArray(int n, int k) {
        int[] answer = new int[n];
        int idx = 0;
        for (int i = 1; i < n - k; ++i) {
            answer[idx] = i;
            ++idx;
        }
        for (int i = n - k, j = n; i <= j; ++i, --j) {
            answer[idx] = i;
            ++idx;
            if (i != j) {
                answer[idx] = j;
                ++idx;
            }
        }
        return answer;
    }
}
