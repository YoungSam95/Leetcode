package leetcode;

import common.ListNode;

/**
 * 2.两数相加
 * 第二次
 */
public class Solution2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //两条链表上的指针
        ListNode p1 = l1, p2 = l2;
        //虚拟头节点
        ListNode dummy = new ListNode(-1);
        //结果
        ListNode p = dummy;
        //进位
        int carry = 0;
        while(p1 != null || p2 != null || carry > 0){
            int val = carry;//先加进位
            if(p1 != null){
                val += p1.val;
                p1 = p1.next;
            }
            if(p2 != null){
                val += p2.val;
                p2 = p2.next;
            }
            //处理进位
            carry = val/10;
            val = val%10;
            //构建新节点
            p.next = new ListNode(val);
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args){

        ListNode a = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode b = new ListNode(5,new ListNode(6,new ListNode(4)));
        ListNode res = addTwoNumbers(a,b);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
