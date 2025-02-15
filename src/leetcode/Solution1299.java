package leetcode;

/**
 * 1299. 将每个元素替换为右侧最大元素
 */
public class Solution1299 {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        ans[n - 1] = -1;
        for (int i = n - 2; i >= 0; --i) {
            ans[i] = Math.max(ans[i + 1], arr[i + 1]);
        }
        return ans;
    }
}
