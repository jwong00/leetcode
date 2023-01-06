import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);
        ListNode k = s.deleteMiddle(h);
        for(ListNode t = k; t!=null; t=t.next) {
            System.out.println(t.val);
        }
    }
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = head;

        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
//    public ListNode deleteMiddle(ListNode head) {
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode pre = dummy;
//        ListNode slow = head, fast = head;
//
//        while(fast!=null && fast.next!=null) {
//            pre=pre.next;
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//        pre.next = slow.next;
//
//        return dummy.next;
//    }
}
