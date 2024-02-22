package leetcode;

import common.TreeNode;

import java.util.HashMap;

/**
 * 889. 根据前序和后序遍历构造二叉树
 * 第二次
 */

public class Solution889 {

    //使用hashmap优化查询inorder中根节点索引的时间
    private HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        for(int i = 0; i < postorder.length; i++){
            map.put(postorder[i],i);
        }
        return build(preorder,0,preorder.length-1,
                postorder,0,postorder.length-1);
    }
    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd){

        if(preStart > preEnd) return null;
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        
        /**root节点对应的值就是前序遍历数组的第一个元素**/
        TreeNode root = new TreeNode(preorder[preStart]);

        /**root.left 的值是前序遍历第二个元素
        通过前序和后序遍历构造二叉树的关键在于通过左子树的根节点
        确定 preorder 和 postorder 中左右子树的元素区间**/
        int leftRootVal = preorder[preStart + 1];
        /**leftRootVal 在后序遍历数组中的索引**/
        int index = map.get(leftRootVal);
        /**左子树的元素个数**/
        int leftSize = index - postStart + 1;

        /**递归构造左右子树
        根据左子树的根节点索引和元素个数推导左右子树的索引边界**/
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                postorder, postStart, index);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                postorder, index + 1, postEnd - 1);

        return root;

    }
}
