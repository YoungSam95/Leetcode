package leetcode;

/**
 * 142.环形链表Ⅱ
 *     思路：当快慢指针相遇时，让其中任一个指针指向头节点，然后让它俩以相同速度前进，再次相遇时所在的节点位置就是环开始的位置。
 */
public class Solution142 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {

        ListNode slow,fast;
        slow = fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if (fast == null || fast.next == null) {
            // fast 遇到空指针说明没有环
            return null;
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        ListNode muddyNode = new ListNode(0);
        ListNode p = node1;
        muddyNode.next = p;
        p.next = node2;
        p = p.next;
        p.next = node3;
        p = p.next;
        p.next = node4;
        p = p.next;
        p.next = node2;
        ListNode res = muddyNode.next;
        ListNode starOfCircle = detectCycle(res);
        System.out.println(starOfCircle.val);
    }

}
