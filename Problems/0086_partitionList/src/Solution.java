/**
 * Created by Glamdring on 1/29/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(7);
        s.partition(head,3);

    }
    public ListNode partition(ListNode head, int x) {
        if(head==null) return null;
        ListNode lowerHead = new ListNode(-1), upperHead = new ListNode(-1);
        ListNode lowerCur = lowerHead, upperCur = upperHead;
        ListNode cur = head;
        /* Iterate through list,
        * val < x sort into lowerHead
        * val >= x sort into upperHead */
        while(cur != null) {
            if(cur.val < x) {
                lowerCur.next = cur;
                lowerCur = lowerCur.next;
            }
            else { //if cur >= x
                upperCur.next = cur;
                upperCur = upperCur.next;
            }
            cur = cur.next;
        }

        lowerCur.next = upperHead.next;
        upperCur.next = null;

        return lowerHead.next;
    }
}
