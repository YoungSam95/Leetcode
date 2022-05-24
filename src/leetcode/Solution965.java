package leetcode;

import common.TreeNode;

/**
 * 965. 单值二叉树
 */
public class Solution965 {
    public static boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        if(root.left != null){
            if(root.val != root.left.val || !isUnivalTree(root.left)){
                return false;
            }
        }
        if(root.right != null){
            if(root.val != root.right.val || !isUnivalTree(root.right)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String str = null;
        System.out.println(str);
        System.out.println(str.length());
    }
}
