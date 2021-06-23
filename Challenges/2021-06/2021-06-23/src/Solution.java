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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode l_pre = dummy;
        ListNode l_cur = dummy.next;
        ListNode r_pre = dummy;
        ListNode r_cur = dummy.next;


        while(l_cur!=null && left>1) {
            l_pre = l_pre.next;
            l_cur = l_cur.next;
            --left;
        }

        while(r_cur!=null && right>1) {
            r_pre = r_pre.next;
            r_cur = r_cur.next;
            --right;
        }

        //

        ListNode t;
        while( l_cur!=r_cur ){
            t = l_cur.next;
            l_cur.next = r_cur.next;
            r_cur.next = l_cur;

            l_cur = t;
            l_pre.next = l_cur;
        }

        return dummy.next;
    }
}
