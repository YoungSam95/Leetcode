package huawei;

import java.util.Scanner;

public class HJ48 {

    public static class Node{
        public int val;
        public Node next;
        public Node(){};
        public Node(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            Node head = new Node();
            head.next = new Node(sc.nextInt());
            for(int i = 1; i <= n-1;i++){
                int aft = sc.nextInt();
                int pre = sc.nextInt();
                insert(head,aft,pre);
            }
            int m = sc.nextInt();
            delete(head,m);
            Node temp = head.next;
            while(temp != null){
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
        }
    }

    private static void delete(Node head, int m) {
        Node temp = head;
        while(temp != null){
            if(temp.next.val == m){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    private static void insert(Node head,int aft, int pre) {
        Node temp = head;
        while(temp != null){
            if(temp.val == pre){
                Node node = temp.next;
                temp.next = new Node(aft);
                temp.next.next = node;
                break;
            }
            temp = temp.next;
        }
    }
}
