package leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144.二叉树的前序遍历
 */
public class Solution144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root,res);
        return res;
    }
    public void preorderTraversal(TreeNode root,List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        preorderTraversal(root.left,res);
        preorderTraversal(root.right,res);
    }
}
