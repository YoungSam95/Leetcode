import java.util.PriorityQueue;

/**
 * 23.合并K个升序链表
 */
public class Solution23 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0) return null;
        //最小堆解法
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        //优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,(a,b) -> (a.val - b.val));
        //将k个链表的头结点加入最小堆
        for(ListNode head : lists){
            if(head != null) pq.add(head);
        }
        while(!pq.isEmpty()){
            //获取最小节点，连接到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            if(node.next != null) pq.add(node.next);
            p = p.next;
        }
        return dummyHead.next;
        /*//归并解法
        return merge(lists,0,lists.length - 1);*/

    }

    public static ListNode merge(ListNode[] lists, int l, int r){
        if(l == r) return lists[l];
        if(l > r) return null;
        int mid = (l + r)/2;
        return mergeTwoLists(merge(lists,l,mid),merge(lists,mid + 1,r));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null) return list1 != null ? list1 : list2;
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // p 指针不断前进
            p = p.next;
        }
        if (p1 != null) p.next = p1;
        if (p2 != null) p.next = p2;

        return dummy.next;

    }

    public static void main(String[] args){
        ListNode a = new ListNode(1,new ListNode(4,new ListNode(5)));
        ListNode b = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode c = new ListNode(2,new ListNode(6));
        ListNode[] lists = {a,b,c};
        ListNode res = mergeKLists(lists);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

}
