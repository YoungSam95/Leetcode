package leetcode;

import common.TreeNode;

/**
 * 112. 路径总和
 */
public class Solution112 {
    int target;
    int cur = 0;
    boolean res = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //解法1
        /*if(root == null) return false;
        if(root.left == root.right && root.val == targetSum) return true;
        return hasPathSum(root.left,targetSum - root.val)
                || hasPathSum(root.right,targetSum - root.val);*/
        //解法2
        target = targetSum;
        if(root == null) return res;
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if(root == null) return;
        cur += root.val;
        if(root.left == null && root.right == null && cur == target){
            res = true;
        }
        traverse(root.left);
        traverse(root.right);
        cur -= root.val;
    }
}
