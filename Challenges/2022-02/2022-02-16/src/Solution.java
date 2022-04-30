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
        ListNode q = new ListNode(1);
        q.next = new ListNode(2);
        q.next.next = new ListNode(3);
        q.next.next.next = new ListNode(4);
        System.out.println(s.swapPairs(q));
    }
    public ListNode swapPairs(ListNode head) {

        //validation
        if(head==null) return null;

        ListNode A = null, B = head, C = null;

        while(B!=null){

            //linking sublists
            ListNode P = A;
            ListNode Q = B;

            //actual sublist reversal
            for(int i=0;B!=null && i<2;i++) {
                C = B.next;
                B.next = A;
                A = B;
                B = C;

            }

            //linking previous sublist to current
            if(P!=null) P.next = A;
            else head = A;

            Q.next = B;
            A = Q;

        }

        return head;

    }
}
