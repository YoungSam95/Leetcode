package leetcode;

/**
 * 2296. 设计一个文本编辑器
 */
public class Solution2296 {
    class Node {
        char val;
        Node prev, next;

        Node(char val) {
            this.val = val;
        }

        void insert(char val) {
            Node node = new Node(val);
            node.next = this;
            node.prev = this.prev;
            if (this.prev != null) {
                this.prev.next = node;
            }
            this.prev = node;
        }

        void remove() {
            Node node = this.prev;
            this.prev = node.prev;
            if (node.prev != null) {
                node.prev.next = this;
            }
        }

        String range(Node end) {
            StringBuilder sb = new StringBuilder();
            Node node = this;
            while (node != end) {
                sb.append(node.val);
                node = node.next;
            }
            return sb.toString();
        }
    }

    class TextEditor {
        private Node cursor;

        public TextEditor() {
            cursor = new Node('\0'); // 空字符表示光标位置
        }

        public void addText(String text) {
            for (char c : text.toCharArray()) {
                cursor.insert(c);
            }
        }

        public int deleteText(int k) {
            int count = 0;
            while (k > 0 && cursor.prev != null) {
                cursor.remove();
                k--;
                count++;
            }
            return count;
        }

        public String cursorLeft(int k) {
            while (k > 0 && cursor.prev != null) {
                cursor = cursor.prev;
                k--;
            }
            Node head = cursor;
            for (int i = 0; i < 10 && head.prev != null; i++) {
                head = head.prev;
            }
            return head.range(cursor);
        }

        public String cursorRight(int k) {
            while (k > 0 && cursor.next != null) {
                cursor = cursor.next;
                k--;
            }
            Node head = cursor;
            for (int i = 0; i < 10 && head.prev != null; i++) {
                head = head.prev;
            }
            return head.range(cursor);
        }
    }
}
