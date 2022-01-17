import java.util.Stack;

/**
 * 155. 最小栈
 *      设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈
 */
public class Solution155 {
    public static class  MinStack {
        Stack<Integer> realStack;
        Stack<Integer> minStack;
        public MinStack() {
            realStack = new Stack<>();
            minStack = new Stack<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            realStack.push(val);
            minStack.push(Math.min(minStack.peek(),val));
        }

        public void pop() {
            realStack.pop();
            minStack.pop();
        }

        public int top() {
            return realStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args){
        MinStack st = new MinStack();
        st.push(-2);
        st.push(0);
        st.push(-3);
        System.out.println(st.getMin());
        st.pop();
        System.out.println(st.top());
        System.out.println(st.getMin());
    }
}
