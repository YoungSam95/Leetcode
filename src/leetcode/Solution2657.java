package leetcode;

/**
 * 2657. 找到两个数组的前缀公共数组
 */
public class Solution2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        long p = 0, q = 0;
        for (int i = 0; i < A.length; i++) {
            p |= 1L << A[i];
            q |= 1L << B[i];
            A[i] = Long.bitCount(p & q);
        }
        return A;
    }
}
