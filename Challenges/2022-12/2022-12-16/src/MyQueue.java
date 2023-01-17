import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {

    Deque<Integer> st;
    int front;

    public MyQueue() {
        st = new ArrayDeque<>();
        front = -1;

    }

    public void push(int x) {
        if(st.isEmpty()) front = x;
        st.push(x);
    }

    public int pop() {
        Deque<Integer> cache = new ArrayDeque<>();
        int ret = -1;
        while(!st.isEmpty()) {
            ret = st.pop();
            if(st.size()==1) front = ret;
            if(st.size()>=1) cache.push(ret);
        }
        while(!cache.isEmpty()) {
            st.push(cache.pop());
        }
        return ret;
    }

    public int peek() {
        return front;
    }

    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
