package leetcode;

import common.TreeNode;

/**
 * 226.镜像翻转二叉树
 * 思路：递归翻转左右子树
 */
public class Solution226 {

    public TreeNode invertTree(TreeNode root) {

        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
