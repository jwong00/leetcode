import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode a = new ListNode(4);
        a.next = new ListNode(1);
        a.next.next = new ListNode(8);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);

        ListNode b = new ListNode(5);
        b.next = new ListNode(0);
        b.next.next = new ListNode(1);
        b.next.next.next = a.next.next;

        System.out.println(s.getIntersectionNode(a,b).val);

        ListNode q = new ListNode(2);
        q.next = new ListNode(6);
        q.next.next = new ListNode(4);

        ListNode r = new ListNode(1);
        r.next = new ListNode(5);

        System.out.println(s.getIntersectionNode(q,r));


    }

    /*
    * Uses two pointers, and they traverse the lists together. If they are ever equal,
    * then the node they are pointing to is the intersecting node.
    * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;

        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }

    /*
    * This solution iterates over the two lists, marking each node by changing
    * the value from positive to negative. It then iterates a second time, searching
    * for a positive value, which is the intersection. It then iterates a third time,
    * restoring all values to their original state.
    * */
    public ListNode _getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;

        while(A != null) {
            A.val *= -1;
            A = A.next;
        }

        while(B != null) {
            B.val *= -1;
            B = B.next;
        }

        A = headA;
        B = headB;
        ListNode intersection = null;

        while(A != null && A.val <= 0) {
            A = A.next;
        }
        intersection = A;

        A=headA;

        while(A != null) {
            A.val=Math.abs(A.val);
            A = A.next;
        }
        while(B != null) {
            B.val=Math.abs(B.val);
            B = B.next;
        }
        return intersection;
    }
}
