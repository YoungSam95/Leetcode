package leetcode;

import common.TreeNode;

/**
 * 101. 对称二叉树
 */

public class Solution101 {

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return check(root.left,root.right);
    }

    public static boolean check(TreeNode left, TreeNode right) {
        //左右都为null 返回true
        if(left == null || right == null) return left == right;
        //如果左右不相等，返回false
        if(left.val != right.val) return false;
        //递归比较左子树的右子树和右子树的左子树 && 左子树的左子树和右子树的右子树
        return check(left.right,right.left) && check(left.left,right.right);
    }

}
