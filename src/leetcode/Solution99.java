package leetcode;

import common.TreeNode;
import tree.Tree;

import java.util.Stack;

/**
 * 99.恢复二叉搜索树
 */
public class Solution99 {

    //记录两个出错的node
    static TreeNode first = null;
    static TreeNode second = null;
    //用于找出出错的node
    static TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public static void recoverTree(TreeNode root) {
        //中序遍历找出错的node，因为二叉搜索树中序遍历是有序的
        inOrderTraverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public static void inOrderTraverse(TreeNode root){
        if(root == null) return;
        inOrderTraverse(root.left);
        // 中序遍历代码位置，找出那两个节点
        if (root.val < prev.val) {
            // root 不符合有序性
            if (first == null) {
                // 第一个错位节点是 prev
                first = prev;
            }
            // 第二个错位节点是 root
            second = root;
        }
        prev = root;
        inOrderTraverse(root.right);
    }

    public static void midOrder1(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty())
        {
            while (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            if(!stack.empty())
            {
                root = stack.pop();
                System.out.print(root.val + "   ");
                root = root.right;
            }
        }
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(5,new TreeNode(2,new TreeNode(1),new TreeNode(8,null,new TreeNode(4))),new TreeNode(7,new TreeNode(6),new TreeNode(3,null,new TreeNode(9))));
        recoverTree(root);
        midOrder1(root);
    }
}
