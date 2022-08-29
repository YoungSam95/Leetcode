package leetcode;

import common.TreeNode;

/**
 * 998. 最大二叉树 II
 */
public class Solution998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.val < val){
            TreeNode temp = root;
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }else{
            root.right = insertIntoMaxTree(root.right,val);
        }
        return root;
    }
}
