package leetcode;

import common.ListNode;
/**
 * 234. 回文链表
 */

public class Solution234 {

    private ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }
    public boolean traverse(ListNode right){
        if(right == null) return true;

        boolean res = traverse(right.next);

        res = res && (left.val == right.val);
        left = left.next;
        return res;
    }
}
