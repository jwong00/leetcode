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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        ListNode r = s.removeElements(head,6);
        while(r!=null) {
            System.out.println(r.val);
            r=r.next;
        }
    }
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;



        ListNode cur = head,pre = sentinel;
        while(cur!=null) {
            if(cur.val==val) {
                pre.next=cur.next;
            }
            else pre = cur;
            cur = cur.next;
        }

        return sentinel.next;

    }
}
