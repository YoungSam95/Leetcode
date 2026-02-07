package leetcode;

import common.TreeNode;

/**
 * 110.平衡二叉树
 * 第二次
 */

public class Solution110 {

    public static boolean isBalanced = true;
    public static boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isBalanced;
    }

    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        if (Math.abs(rightMaxDepth - leftMaxDepth) > 1) {
            isBalanced = false;
        }
        return 1 + Math.max(leftMaxDepth, rightMaxDepth);
    }
}
