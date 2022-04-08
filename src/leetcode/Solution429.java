package leetcode;

import common.Node;

import java.util.*;

/**
 * 429.N叉树的层序遍历
 */

public class Solution429 {

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node node = q.poll();
                level.add(node.val);
                if(node.children.size() != 0){
                    q.addAll(node.children);
                }
            }
            res.add(level);
        }
        return res;
    }
}
