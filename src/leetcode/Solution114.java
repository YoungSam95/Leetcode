package leetcode;

import common.TreeNode;

/**
 * 114. 二叉树展开为链表
 */
public class Solution114 {

    public void flatten(TreeNode root) {

        if(root == null) return;
        //递归处理左右子树
        flatten(root.left);
        flatten(root.right);

        /**后序遍历位置**/
        //1左右子树已经处理完成链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        //2将左子树设为null，右子树设为左子树
        root.left = null;
        root.right = left;

        //3将右子树续接到左子树
        TreeNode head = root;
        while(head.right != null){
            head = head.right;
        }
        head.right = right;

    }
}
