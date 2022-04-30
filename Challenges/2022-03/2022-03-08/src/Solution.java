import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution  s = new Solution();

        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(0);
        l1.next.next.next = new ListNode(-4);
        l1.next.next.next.next = l1.next;

        System.out.println(s.hasCycle(l1));

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = l2;

        System.out.println(s.hasCycle(l2));

        ListNode l3 = new ListNode(1);

        System.out.println(s.hasCycle(l3));

    }
    public boolean hasCycle(ListNode head) {

        if(head==null) return false;

        ListNode slow = head, fast = head;

        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;

            if(slow==fast) return true;
        }

        return  false;
    }
}

