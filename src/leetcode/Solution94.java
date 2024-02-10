package leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *94.二叉树的中序遍历
 * 第二次
 */
public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root,list);
        return list;
    }
    public void inorderTraversal(TreeNode root,List<Integer> list){
        if(root == null) return;
        inorderTraversal(root.left,list);
        list.add(root.val);
        inorderTraversal(root.right,list);
    }

}
