package leetcode;

import common.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 第二次
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode slow = head,fast = head;
        while(fast != null){
            if(slow.val != fast.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
