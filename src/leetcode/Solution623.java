package leetcode;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 623. 在二叉树中增加一行
 */
public class Solution623 {
    private int val;
    private int depth;
    private int currDep = 0;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        this.val = val;
        this.depth = depth;
        if(depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        traverse(root);
        return root;
    }
    public TreeNode addOneRow2(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        List<TreeNode> curLevel = new ArrayList<TreeNode>();
        curLevel.add(root);
        for (int i = 1; i < depth - 1; i++) {
            List<TreeNode> tmpt = new ArrayList<TreeNode>();
            for (TreeNode node : curLevel) {
                if (node.left != null) {
                    tmpt.add(node.left);
                }
                if (node.right != null) {
                    tmpt.add(node.right);
                }
            }
            curLevel = tmpt;
        }
        for (TreeNode node : curLevel) {
            node.left = new TreeNode(val, node.left, null);
            node.right = new TreeNode(val, null, node.right);
        }
        return root;
    }

    public void traverse(TreeNode root) {
        if(root == null) return;
        currDep++;
        if(currDep == depth - 1){
            TreeNode newLeft = new TreeNode(val);
            TreeNode newRight = new TreeNode(val);
            newLeft.left = root.left;
            newRight.right = root.right;
            root.left = newLeft;
            root.right = newRight;
        }
        traverse(root.left);
        traverse(root.right);
        currDep--;
    }
}
