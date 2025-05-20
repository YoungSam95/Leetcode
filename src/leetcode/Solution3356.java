package leetcode;

/**
 * 3356. 零数组变换 II
 */
public class Solution3356 {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] deltaArray = new int[n + 1];
        int operations = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            operations += deltaArray[i];
            while (k < queries.length && operations < num) {
                int left = queries[k][0];
                int right = queries[k][1];
                int value = queries[k][2];
                deltaArray[left] += value;
                deltaArray[right + 1] -= value;
                if (left <= i && i <= right) {
                    operations += value;
                }
                k++;
            }
            if (operations < num) {
                return -1;
            }
        }
        return k;
    }
}
