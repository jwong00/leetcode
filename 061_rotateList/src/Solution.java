import java.util.ArrayList;

/**
 * Created by Glamdring on 1/31/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);
        h.next.next.next.next = new ListNode(5);
//        h.print();
//        s.rotateRight(h,2).print();
        s.rotateRight(h, 5).print();
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k <= 0) return head;
        ListNode cur=head;
        ListNode kTrailing = head;
        ArrayList<ListNode> list = new ArrayList<>();
        int length = 0, j=k;
        while(cur.next != null) {
            list.add(cur);
            cur=cur.next;
            length++;
        }
        list.add(cur);
        length++;
        if(length==1 || k%length==0) return head;
        else {
            kTrailing = list.get(length - 1- k % length);
            ListNode newHead;
            newHead = kTrailing.next;
            cur = list.get(length-1);
            kTrailing.next = null;
            cur.next = head;
            return newHead;

        }
    }
}
