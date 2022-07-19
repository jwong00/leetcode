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
        ListNode A = new ListNode(4);
        A.next=new ListNode(1);
        A.next.next = new ListNode(8);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(5);
        ListNode B = new ListNode(5);
        B.next = new ListNode(6);
        B.next.next = new ListNode(1);
        B.next.next.next = A.next.next;

        Solution s = new Solution();
        System.out.println(s.getIntersectionNode(A,B).val);

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;

        while(A!=B) {
            A = A==null ? headB : A.next;
            B = B==null ? headA : B.next;
        }

        return A;

    }
}
