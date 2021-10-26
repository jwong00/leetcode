import javax.swing.event.MouseInputAdapter;
import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
    public static void main(String[] args) {
        MinStack st = new MinStack();
        st.push(-2);
        st.push(0);
        st.push(-3);
        System.out.println(st.getMin());
        st.pop();
        System.out.println(st.top());
        System.out.println(st.getMin());
    }
    Deque<Integer> values;
    Deque<Integer> minima;

    public MinStack() {
        values = new ArrayDeque<>();
        minima = new ArrayDeque<>();

    }

    public void push(int val) {
        values.push(val);
        if(minima.isEmpty()) minima.push(val);
        else minima.push(Math.min(minima.peek(),val));

    }

    public void pop() {
        values.pop();
        minima.pop();

    }

    public int top() {
        return values.peek();
    }

    public int getMin() {
        return minima.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
