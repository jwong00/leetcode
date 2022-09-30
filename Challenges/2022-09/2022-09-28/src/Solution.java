import java.util.List;

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
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next   = new ListNode(5);

//        System.out.println(s.removeNthFromEnd(l1,2).val);
//        System.out.println("xxx");
//        while(l1!=null) {
//            System.out.println(l1.val);
//            l1=l1.next;
//        }

        ListNode l2 = new ListNode(2);
        l2 = s.removeNthFromEnd(l2,1);
        while(l2!=null) {
            System.out.println(l2.val);
            l2=l2.next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1,head);
        ListNode A=sentinel,B=sentinel;

        //assert n < list.length
        while(n>0) {
            B=B.next;
            --n;
        }

        while(B.next!=null) {
            A=A.next;
            B=B.next;
        }

        A.next = A.next.next;

        return sentinel.next;
    }
}
