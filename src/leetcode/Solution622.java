package leetcode;

import common.ListNode;

/**
 * 622. 设计循环队列
 */
public class Solution622 {
    class MyCircularQueue {
        private ListNode head;
        private ListNode tail;
        private int size;
        private int currSize;

        public MyCircularQueue(int k) {
            this.size = k;
            this.currSize = 0;
        }

        public boolean enQueue(int value) {
            if(isFull()) return false;
            ListNode node = new ListNode(value);
            if(head == null){
                head = tail = node;
            }else{
                tail.next = node;
                tail = node;
            }
            this.currSize++;
            return true;
        }

        public boolean deQueue() {
            if(isEmpty()) return false;
            head = head.next;
            this.currSize--;
            return true;
        }

        public int Front() {
            if(isEmpty()) return -1;
            return head.val;
        }

        public int Rear() {
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
