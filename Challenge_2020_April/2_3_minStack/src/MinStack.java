import java.util.ArrayList;
import java.util.Stack;

class MinStack {
//    private int top;
    private Stack<Integer> values;
    private Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        min = new Stack<>();
        values = new Stack<>();

    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();

        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.top());
        System.out.println(ms.getMin());

    }

    public void push(int x) {
        values.push(x);
        if(min.isEmpty()) min.push(x);
        else {
            int m = x < min.peek() ? x : min.peek();
            min.push(m);
        }
    }

    public void pop() {
        values.pop();
        min.pop();
    }

    public int top() {
        if(values.isEmpty() || min.isEmpty()) return -1;
        else return values.peek();
    }

    public int getMin() {
        if(min.isEmpty()) return -1;
        else return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
