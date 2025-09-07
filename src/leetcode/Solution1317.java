package leetcode;

/**
 * 1317. 将整数转换为两个无零整数的和
 */
public class Solution1317 {
    public int[] getNoZeroIntegers(int n) {
        for (int A = 1; A < n; ++A) {
            int B = n - A;
            if (!String.valueOf(A).contains("0") && !String.valueOf(B).contains("0")) {
                return new int[]{A, B};
            }
        }
        return new int[0];
    }
}
