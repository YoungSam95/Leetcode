package leetcode;

/**
 * 206:反转链表
 */

public class Solution206 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode reverseList(ListNode head) {

        //方法1：递归
        /*if (head == null || head.next == null) {//head为null或者递归到最后一个元素就返回
            return head;
        }
        ListNode last = reverseList(head.next);//last接受上层栈最后一个元素；
        head.next.next = head;//把head放在last后面
        head.next = null;//把head的last指向null；
        return last;*/

        //方法2：迭代
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args){

        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode res = reverseList(head);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
