package leetcode;

import common.TreeNode;

/**
 * 814. 二叉树剪枝
 */
public class Solution814 {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.val == 0 && root.left == null && root.right == null) return null;
        return root;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1,new TreeNode(0),new TreeNode(1));
        Solution814 s = new Solution814();
        s.pruneTree(root);
    }
}
