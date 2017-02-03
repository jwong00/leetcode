import java.util.ArrayList;

/**
 * Created by Glamdring on 1/31/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode h = new ListNode(1);
//        h.next = new ListNode(2);
//        h.next.next = new ListNode(3);
//        h.next.next.next = new ListNode(4);
//        h.next.next.next.next = new ListNode(5);
        h.print();
//        s.rotateRight(h,2).print();
        s.rotateRight(h,3).print();
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k <= 0) return head;
        ListNode cur=head;
        ListNode kTrailing = head;
        ArrayList<ListNode> list = new ArrayList<>();
        int length = 0, j=k;
        while(cur.next != null) {
//            if(j>0) j--; //let cur get ahead
//            else if(kTrailing.next != null) kTrailing = kTrailing.next;
            list.add(cur);
            cur=cur.next;
            length++;
        }
//        kTrailing=kTrailing.next;
        list.add(cur);
        length++;
        System.out.println(length);
        System.out.println(k);

//        System.out.println(kTrailing.val);
//        System.out.println(cur.val);
//        System.out.println(list.get(length - 1 - k % length));
//        System.out.println(list.get(length-1));

        kTrailing = list.get(length - 1- k % length);
        ListNode newHead = kTrailing.next;
        cur = list.get(length-1);
        kTrailing.next = null;
        cur.next = head;

        return newHead;
//        return null;
    }
}
