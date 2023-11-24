package leetcode;

import common.TreeNode;

/**
 * 1457. 二叉树中的伪回文路径
 */
public class Solution1457 {
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] counter = new int[10];
        return dfs(root, counter);
    }

    public int dfs(TreeNode root, int[] counter) {
        if (root == null) {
            return 0;
        }
        counter[root.val]++;
        int res = 0;
        if (root.left == null && root.right == null) {
            if (isPseudoPalindrome(counter)) {
                res = 1;
            }
        } else {
            res = dfs(root.left, counter) + dfs(root.right, counter);
        }
        counter[root.val]--;
        return res;
    }

    public boolean isPseudoPalindrome(int[] counter) {
        int odd = 0;
        for (int value : counter) {
            if (value % 2 == 1) {
                odd++;
            }
        }
        return odd <= 1;
    }
}
