import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(s.middleNode(head));
    }
    public ListNode middleNode(ListNode head) {
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode slow = dummy, fast = dummy;
        ListNode slow = head, fast = head;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
