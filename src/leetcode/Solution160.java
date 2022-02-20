package leetcode;

import java.util.HashSet;

/**
 * 160.相交链表
 */
public class Solution160 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        /*//HashSet解法
        ListNode a = headA, b = headB;
        HashSet<ListNode> set = new HashSet<>();
        while( a != null){
            set.add(a);
            a = a.next;
        }
        while( b != null){
            if(set.contains(b)) return b;
            b = b.next;
        }
        return null;*/
        //双指针解法
        ListNode a = headA, b = headB;
        while(a != b){
            if(a == null) a = headB;
            else a = a.next;
            if(b == null) b = headA;
            else b = b.next;
        }
        return a;

    }

}
