package leetcode;

import common.TreeNode;

/**
 * 面试题 04.06. 后继者
 */
public class Solution0406 {

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode curr = root, res = null;
        while(curr != null){
            if(p.val < curr.val){
                res = curr;
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
        return res;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode().deserialize("4,2,6,1,3,5,7");
        System.out.println(inorderSuccessor(root,root.left).val);
    }
}
