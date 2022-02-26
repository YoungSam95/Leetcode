package leetcode;

import common.TreeNode;

/**
 * 104.二叉树的最大深度
 */
public class Solution104 {
    /**
    //回溯法
    int res = 0;
    int depth = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root){
        if(root == null) return;
        depth++;
        res = Math.max(res,depth);
        traverse(root.left);
        traverse(root.right);
        depth--;
    }*/
    //动态规划
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return 1 + Math.max(leftMax,rightMax);
    }

}
