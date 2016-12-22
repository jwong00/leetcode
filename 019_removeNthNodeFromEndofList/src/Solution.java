/**
 * Created by Glamdring on 12/5/2016.
 */
public class Solution {
    public static void main(String[] args) {

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int k=n;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre=dummy;
        ListNode cur=head;
        ListNode forward=head;

        while(k>1) { //cur and forward should be n apart
            forward=forward.next;
            k--;
        }
        while(forward.next!=null) { //find Nth elem from end
            pre = cur;
            cur=cur.next;
            forward=forward.next;
        }
        pre.next=cur.next;
        return dummy.next;
    }

    public void printList(ListNode head) {
        ListNode cur=head;
        do {
            System.out.print(cur.toString() + " ");
            cur=cur.next;
        } while(cur!=null);
        System.out.println("");

    }
}
