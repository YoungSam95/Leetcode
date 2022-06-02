package leetcode;
/**
 * 450. 删除二叉搜索树中的节点
 */

import common.TreeNode;

public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){
            if(root.right == null) return root.left;
            if(root.left == null) return root.right;
            //找到右子树最小的节点
            TreeNode minNode = root.right;
            while(minNode.left != null) minNode = minNode.left;
            root.right = deleteNode(root.right,minNode.val);
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        }else if(root.val > key){
            root.left = deleteNode(root.left,key);
        }else{
            root.right = deleteNode(root.right,key);
        }
        return root;
    }
}
