import java.util.Stack;

/**
 * Created by Glamdring on 4/27/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
//        h.next.next = new ListNode(3);
//        h.next.next.next = new ListNode(4);
        System.out.println(h);
        System.out.println(s.reverseList(h));
    }
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        Stack s = new Stack();
        while(head!=null) {
            s.push(head);
            head=head.next;
        }
        ListNode cur = (ListNode) s.pop();
        head = cur;
        while(!s.isEmpty()) {
            cur.next = (ListNode) s.pop();
            cur=cur.next;
        }
        cur.next=null;
        return head;
    }
}
