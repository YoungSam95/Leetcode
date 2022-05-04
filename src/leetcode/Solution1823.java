package leetcode;

/**
 * 1823. 找出游戏的获胜者
 */
public class Solution1823 {

    class Node{
        int number;
        Node next;
        Node(int number){
            this.number = number;
        }
        Node(int number,Node next){
            this.number = number;
            this.next = next;
        }
    }
    public int findTheWinner(int n, int k) {
        if(k == 1) return n;
        Node curr = new Node(1);
        Node head = curr;
        for(int i = 2; i <= n; i++){
            head.next = new Node(i);
            head = head.next;
        }
        head.next = curr;
        while(curr.next != curr){
            int m = 0;
            while(m < k - 2){
                curr = curr.next;
                m++;
            }
            curr.next = curr.next.next;
            curr = curr.next;
        }
        return curr.number;
    }
}
