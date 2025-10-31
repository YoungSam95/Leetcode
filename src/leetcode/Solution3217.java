package leetcode;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3217. 从链表中移除在数组中存在的节点
 */
public class Solution3217 {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        ListNode sentry = new ListNode(0, head);
        ListNode p = sentry;
        while (p.next != null) {
            if (numSet.contains(p.next.val)) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return sentry.next;
    }
}
