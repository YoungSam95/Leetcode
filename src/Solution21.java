/**
 * 21 合并两个有序链表
 */
public class Solution21 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1), p = dummy;
        while (list1 != null && list2 != null) {
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (list1.val > list2.val) {
                p.next = list2;
                list2 = list2.next;
            } else {
                p.next = list1;
                list1 = list1.next;
            }
            // p 指针不断前进
            p = p.next;
        }
        if (list1 != null) p.next = list1;
        if (list2 != null) p.next = list2;

        return dummy.next;

    }

    public static void main(String[] args){
        ListNode list1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode list2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode res = mergeTwoLists(list1,list2);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
