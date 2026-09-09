package leetcode;

import common.TreeNode;

/**
 * 2265. 统计值等于子树平均值的节点数
 */
public class Solution2265 {
    private int ans;

    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }
        int[] left = dfs(node.left);
        int leftSum = left[0];
        int leftSize = left[1];
        int[] right = dfs(node.right);
        int rightSum = right[0];
        int rightSize = right[1];
        int Size = leftSize + rightSize + 1;
        int Sum = leftSum + rightSum + node.val;
        if (Size > 0 && Sum / Size == node.val) {
            ans++;
        }
        return new int[] { Sum, Size };
    }
}
