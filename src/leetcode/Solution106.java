package leetcode;

import common.TreeNode;

import java.util.HashMap;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */

public class Solution106 {

    //使用hashmap优化查询inorder中根节点索引的时间
    private HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return build(inorder,0,inorder.length-1,
                postorder,0,postorder.length-1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = map.get(postorder[postEnd]);
        int leftSize = index - inStart;
        root.left = build(inorder,inStart,index - 1,
                          postorder,postStart,postStart + leftSize - 1);
        root.right = build(inorder,index + 1,inEnd,
                           postorder,postStart + leftSize,postEnd - 1);
        return root;
    }
}
