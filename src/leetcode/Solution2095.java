package leetcode;

import common.ListNode;

/**
 * 2095. 删除链表的中间节点
 */
public class Solution2095 {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        pre.next = pre.next.next;
        return head;
    }
}
