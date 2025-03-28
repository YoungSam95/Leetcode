package leetcode;

/**
 * 2360. 图中的最长环
 */
public class Solution2360 {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] label = new int[n];
        int current_label = 0, ans = -1;
        for (int i = 0; i < n; ++i) {
            if (label[i] != 0) {
                continue;
            }
            int pos = i, start_label = current_label;
            while (pos != -1) {
                ++current_label;
                // 如果遇到了已经遍历过的节点
                if (label[pos] != 0) {
                    // 如果该节点是这一次 i 循环中遍历的，说明找到了新的环，更新答案
                    if (label[pos] > start_label) {
                        ans = Math.max(ans, current_label - label[pos]);
                    }
                    break;
                }
                label[pos] = current_label;
                pos = edges[pos];
            }
        }
        return ans;
    }
}
