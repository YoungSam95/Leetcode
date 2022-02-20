package leetcode;

/**
 * 141.环形链表Ⅰ
 *     思路：用两个指针，一个跑得快，一个跑得慢。如果不含有环，跑得快的那个指针最终会遇到 null，说明链表不含环；如果含有环，快指针最终会超慢指针一圈，和慢指针相遇，说明链表含有环。
 */
public class Solution141 {

     private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
     }

    public static boolean hasCycle(ListNode head) {

         ListNode slow = head,fast = head;
         while(fast != null && fast.next != null){
             slow = slow.next;
             fast = fast.next.next;
             if(fast == slow) return true;
         }
         return false;

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
         System.out.print(hasCycle(res));
     }
}
