package leetcode;
/**
 * 116. 填充每个节点的下一个右侧节点指针
 */

import common.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution116 {

    public Node connect(Node root) {
        /*if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Node> level = new ArrayList<Node>();
            for(int i=0;i<size;i++){
                Node node = queue.poll();
                level.add(node);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            for(int i=0;i<size;i++){
                if(i == size-1){
                    level.get(i).next = null;
                }else {
                    level.get(i).next = level.get(i + 1);
                }
            }
        }
        return root;*/

        if(root == null) return null;
        connectTwoNode(root.left,root.right);
        return root;
    }
    public void connectTwoNode(Node node1,Node node2){

        if(node1 == null || node2 == null) return;
        node1.next = node2;
        connectTwoNode(node1.left,node1.right);
        connectTwoNode(node2.left,node2.right);
        connectTwoNode(node1.right,node2.left);
    }
}
