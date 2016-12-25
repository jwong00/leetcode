/**
 * Created by Glamdring on 12/22/2016.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(5);
        l1.next.next.next = new ListNode(8);
        s.printList(l1);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(5);
        s.printList(l2);
        ListNode r = s.mergeTwoLists(l1, l2);
        s.printList(r);

    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode pre = new ListNode(-1);
        ListNode newHead = pre;
        while(p1 != null || p2 != null) {
            if(p1 == null ) {
//                System.out.println(p2); //only traversing l2 (l1 done)
                pre.next=p2;
                pre=pre.next;
                p2=p2.next;
            }
            else if(p2 == null) {
//                System.out.println(p1); //only traversing l1 (l2 done)
                pre.next=p1;
                pre=pre.next;
                p1=p1.next;
            }
            else if(p1.val <= p2.val) { //both
//                System.out.println(p1);
                pre.next=p1;
                pre=pre.next;
                p1=p1.next;
            }
            else {
//                System.out.println(p2.val); //p2 strictly LT
                pre.next=p2;
                pre=pre.next;
                p2=p2.next;
            }
        }
        return newHead.next;
    }
    public void printList(ListNode head) {
        ListNode cur = head;
        while(cur!=null) {
            System.out.print(cur + " ");
            cur=cur.next;
        }
        System.out.println(" ");
    }
}
