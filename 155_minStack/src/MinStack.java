/**
 * Created by Glamdring on 3/19/2017.
 */
public class MinStack {
    ListNode top;
    ListNode minStk; //keep a second stack of the same height, which tracks current min val
    int min=0;
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(top!=null) {
            top.next = new ListNode(x);
            top.next.pre = top;
            top=top.next;
        }
        else top = new ListNode(x);
    }

    public void pop() {
        top=top.pre;
        top.next=null;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {

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
