package leetcode;

import common.ListNode;

/**
 * 641. 设计循环双端队列
 */
public class Solution641 {
    class MyCircularDeque {

        private int size;
        private int currSize;
        private ListNode head;
        private ListNode tail;

        public MyCircularDeque(int k) {
            this.size = k;
            this.currSize = 0;
        }

        public boolean insertFront(int value) {
            if(isFull()) return false;
            if(isEmpty()){
                head = new ListNode(value);
                tail = head;
                head.next = tail;
                tail.next = head;
            }else{
                ListNode node = new ListNode(value);
                node.next = head;
                tail.next = node;
                head = node;
            }
            currSize++;
            return true;
        }

        public boolean insertLast(int value) {
            if(isFull()) return false;
            if(isEmpty()){
                head = new ListNode(value);
                tail = head;
                head.next = tail;
                tail.next = head;
            }else{
                ListNode node = new ListNode(value);
                tail.next = node;
                node.next = head;
                tail = node;
            }
            currSize++;
            return true;
        }

        public boolean deleteFront() {
            if(isEmpty()) return false;
            head = head.next;
            tail.next = head;
            currSize--;
            return true;
        }

        public boolean deleteLast() {
            if(isEmpty()) return false;
            ListNode node = head;
            while(node.next != tail){
                node = node.next;
            }
            tail = node;
            tail.next = head;
            currSize--;
            return true;
        }

        public int getFront() {
            if(isEmpty()) return -1;
            return head.val;
        }

        public int getRear() {
            if(isEmpty()) return -1;
            return tail.val;
        }

        public boolean isEmpty() {
            return this.currSize == 0;
        }

        public boolean isFull() {
            return this.currSize == this.size;
        }
    }
}
