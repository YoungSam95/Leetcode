package leetcode;

import common.TreeNode;

/**
 * 654.最大二叉树
 * count = 2;
 */
public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums,0,nums.length -1);
    }
    public TreeNode build(int[] nums,int lo,int hi){
        if(lo > hi){
            return null;
        }
        int index = -1, maxVal = Integer.MIN_VALUE;
        for(int i = lo; i <= hi; i++){
            if(nums[i] > maxVal){
                index = i;
                maxVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums,lo,index-1);
        root.right = build(nums,index+1,hi);
        return root;
    }
}
