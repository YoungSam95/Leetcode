package leetcode;

import common.TreeNode;

/**
 * 2415. 反转二叉树的奇数层
 */
public class Solution2415 {
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, true);
        return root;
    }

    public void dfs(TreeNode root1, TreeNode root2, boolean isOdd) {
        if (root1 == null) {
            return;
        }
        if (isOdd) {
            int temp = root1.val;
            root1.val = root2.val;
            root2.val = temp;
        }
        dfs(root1.left, root2.right, !isOdd);
        dfs(root1.right, root2.left, !isOdd);
    }
}
