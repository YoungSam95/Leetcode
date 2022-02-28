package leetcode;

import common.TreeNode;

import java.util.HashMap;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */

public class Solution105 {

    //使用hashmap优化查询inorder中根节点索引的时间
    private HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,
                     inorder,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if(preStart > preEnd) return null;
        /*int index = -1;
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == preorder[preStart]){
                index = i;
                break;
            }
        }*/
        int index = map.get(preorder[preStart]);
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = build(preorder,preStart+1,preStart+leftSize,
                          inorder,inStart,index-1);
        root.right = build(preorder,preStart+leftSize+1,preEnd,
                           inorder,index+1,inEnd);
        return root;
    }

}
