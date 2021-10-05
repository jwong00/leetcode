import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    public static void main(String[] args) {

        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        System.out.println(s.pop());
        System.out.println(s.top());
        System.out.println(s.empty());
    }
    LinkedList<Integer> q;
    int size;

    /** Initialize your data structure here. */
    public MyStack() {
        q = new LinkedList<>();
        size = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.offer(x);
        size++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int count = size;
        Integer e;

        /*
        * rotate elements from the front to the back of the queue
        * until the logical top of the stack is retrieved
        * */
        do {
            e = q.poll();
            q.offer(e);
            count--;
        } while(count > 1);
        e = q.poll();
        size--;
        return e;
    }

    /** Get the top element. */
    public int top() {
        int count = size;
        Integer e;

        /*
         * rotate elements from the front to the back of the queue
         * until the logical top of the stack is retrieved
         * */
        do{
            e = q.poll();
            q.offer(e);
            count--;
        } while(count > 0);
        return e;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return size==0;
    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
