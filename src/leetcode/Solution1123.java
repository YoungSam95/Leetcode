package leetcode;

import common.TreeNode;

/**
 * 1123. 最深叶节点的最近公共祖先
 * 第二次
 */
public class Solution1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null) return null;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left == right) return root;
        else if(left < right) return lcaDeepestLeaves(root.right);
        return lcaDeepestLeaves(root.left);
    }
    int dfs(TreeNode  node){
        if(node==null) return 0;
        return 1 + Math.max(dfs(node.right), dfs(node.left));
    }
}
