package leetcode;

import common.ListNode;

/**
 * 1290. 二进制链表转整数
 */
public class Solution1290 {
    public int getDecimalValue(ListNode head) {
        ListNode curNode = head;
        int ans = 0;
        while (curNode != null) {
            ans = ans * 2 + curNode.val;
            curNode = curNode.next;
        }
        return ans;
    }
}
