package leetcode;

import common.TreeNode;

/**
 * 230. 二叉搜索树中第K小的元素
 */

public class Solution230 {

    static public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    // 记录结果
    static public int res = 0;
    // 记录当前元素的排名
    static public int rank = 0;
    static public void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        /* 中序遍历代码位置 */
        rank++;
        if (k == rank) {
            // 找到第 k 小的元素
            res = root.val;
            return;
        }
        /*****************/
        traverse(root.right, k);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5,new TreeNode(3,new TreeNode(2,new TreeNode(1),null),new TreeNode(4)),new TreeNode(6));
        System.out.println(kthSmallest(root,3));
    }
}
