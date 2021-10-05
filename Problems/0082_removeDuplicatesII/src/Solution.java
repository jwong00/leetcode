/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public static void main(String args[]) {
        Solution s = new Solution();
        ListNode head = new ListNode(1);
        head.add(2);
        head.add(3);
        head.add(3);
        head.add(4);
        head.add(4);
        head.add(5);
        head.print("Before");
        s.deleteDuplicates(head).print("After");
        head = new ListNode(1);
        head.add(1);
        head.add(1);
        head.add(2);
        head.add(3);
        head.print("Before");
        s.deleteDuplicates(head).print("After");
//        head.next = new ListNode(2);
//        head.next.next = new ListNode
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode fast = head;
        ListNode slow = new ListNode(-1);
        ListNode dummy = slow;

        while(fast!=null && fast.next!=null) {
            int val = fast.val;
            /*
            * if two consecutive values are equal, send one pointer forward until a
            * new value is found
            * */
            if(fast.val==fast.next.val) while(fast!=null && fast.val==val) fast=fast.next;
            /*
            * let the slow pointer point to the new number, then have it catchup, then send
            * the fast pointer forward again
            * */
            else {
                slow.next=fast;
                slow=slow.next;
                fast=fast.next;
            }
        }
        slow.next=fast; //catch up the slow cursor
        return dummy.next;
    }
}
