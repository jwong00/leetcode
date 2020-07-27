import java.util.Stack;

class MyQueue {

    Stack<Integer> s;
    int size;
    int front;

    /** Initialize your data structure here. */
    public MyQueue() {
        s = new Stack<Integer>();
        size = 0;
        front=0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(s.isEmpty()) front = x;
        size++;
        s.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(size<=0) return 0;
        Stack<Integer> t = new Stack<Integer>();
        while(!s.isEmpty()) {
            t.push(s.pop());
        }

        int k = t.pop();

        while(!t.isEmpty()) {
            if(s.isEmpty()) {
                front = t.pop();
                s.push(front);
            }
            else s.push(t.pop());
        }

        size--;

        return k;

    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return size==0;
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
