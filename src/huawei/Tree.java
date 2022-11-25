package huawei;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Tree {
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int value){
            this.value = value;
        }
        TreeNode(int value, TreeNode left, TreeNode right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    public static void travers(TreeNode root, List<Integer> res){
        if(root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        res.add(root.value);
        stack.push(root);
        while(root.left != null){
            res.add(root.left.value);
            stack.push(root.left);
            root = root.left;
        }
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right != null){
                res.add(node.right.value);
                stack.push(node.right);
                node = node.right;
                while(node.left != null){
                    res.add(node.left.value);
                    stack.push(node.left);
                    node = node.left;
                }
            }
        }
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1,
                                     new TreeNode(2,new TreeNode(4), new TreeNode(5)),
                                     new TreeNode(3,new TreeNode(6), new TreeNode(7)));
        List<Integer> res = new ArrayList<>();
        travers(root,res);
        for(int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
        }
    }
}
