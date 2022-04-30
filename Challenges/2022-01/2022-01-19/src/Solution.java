class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        int length = 0;
        ListNode slow = head, fast = head;

        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;

            if(slow==fast) return findStart(head,cycleLength(slow));
        }

        return null;
    }

    private static ListNode findStart(ListNode node, int length) {
        ListNode ptr1 = node, ptr2 = node;

        while(length>0) {
            ptr2 = ptr2.next;
            length--;
        }

        while(ptr1!=ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }

    private static int cycleLength(ListNode node) {
        ListNode cur = node;
        int length = 0;
        do {
            cur = cur.next;
            length++;
        } while(cur!=node);

        return length;
    }
}


