package leetcode;

import common.TreeNode;

public class Solution235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val,q.val);
        int max = Math.max(p.val,q.val);
        return lowestCommonAncestor(root,min,max);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, int min, int max) {

        if(root == null) return null;
        //如果当前root.val比min还小，去右子树找
        if(root.val < min){
            return lowestCommonAncestor(root.right,min,max);
        }
        //如果当前root.val比max还大，去左子树找
        if(root.val > max){
            return lowestCommonAncestor(root.left,min,max);
        }
        //此时min<= root.val <= max,则当前root为最近公共祖先
        return root;
    }

    public static void main(String[] args){
        String[] str = {"6","2","8","0","4","7","9","null","null","3","5"};
        TreeNode root = new TreeNode().deserialize(str);
        System.out.println(lowestCommonAncestor(root,7,8).val);
    }
}
