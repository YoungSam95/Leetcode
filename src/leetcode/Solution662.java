package leetcode;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 662. 二叉树最大宽度
 */
public class Solution662 {
    // 记录节点和对应编号
    class Pair {
        TreeNode node;
        int id;

        public Pair( TreeNode node, int id) {
            this.node = node;
            this.id = id;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        // 记录最大的宽度
        int maxWidth = 1;
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 1));
        while (!q.isEmpty()) {
            int sz = q.size();
            int start = 0, end = 0;
            // 从左到右遍历每一行
            for (int i = 0; i < sz; i++) {
                Pair cur = q.poll();
                TreeNode curNode = cur.node;
                int curId = cur.id;
                // 记录当前行第一个和最后一个节点的编号
                if (i == 0) {
                    start = curId;
                }
                if (i == sz - 1) {
                    end = curId;
                }
                // 左右子节点入队，同时记录对应节点的编号
                if (curNode.left != null) {
                    q.offer(new Pair(curNode.left, curId * 2));
                }
                if (curNode.right != null) {
                    q.offer(new Pair(curNode.right, curId * 2 + 1));
                }
            }
            // 用当前行的宽度更新最大宽度
            maxWidth = Math.max(maxWidth, end - start + 1);
        }

        return maxWidth;
    }
}
