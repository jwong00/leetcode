/**
 * Created by Glamdring on 3/19/2017.
 */


public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
    /* Consists of two parallel stacks. One for the values pushed onto the "regular" stack,
     * and one for tracking the minimum of all values pushed.
     * */
    ListNode top;
    ListNode minTop; //keep a second stack of the same height, which tracks current min val
    int min=0;
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        ListNode cur;
        if(top!=null) { //implies minTop != null
            cur = new ListNode(x);
            cur.next = top;
            top = cur;

            if(x<=minTop.val) { //push a new min val onto minStack
                cur = new ListNode(x);
            }
            else { //
                cur = new ListNode(minTop.val);
            }

            cur.next = minTop;
            minTop = cur;
        }
        else {
            top = new ListNode(x);
            minTop = new ListNode(x);
        }
    }

    public void pop() {
        top=top.next;

        minTop = minTop.next;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return minTop.val;
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
