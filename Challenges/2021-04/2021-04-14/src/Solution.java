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
        ListNode q = new ListNode(2);
        q.next = new ListNode(1);
        q=s.partition(q,2);
        ListNode c = q;
        while(c!=null) {
            System.out.println(c.val);
            c=c.next;
        }
    }
    public ListNode partition(ListNode head, int x) {
        if(head==null) return null;
        ListNode dummy=new ListNode(Integer.MIN_VALUE),p1=dummy,p2=head,p2pre=dummy;

        dummy.next=head;

        //set p2 to first instance of partition value
        while(p2.next!=null && p2.val<x) {
            p2pre=p2;
            p2=p2.next;
        }
        System.out.println("P2 is at: " +p2.val);

        //set p1 to be any node lower or before target, this is is the insertion point
        while(p1.next!=null && p1.next != p2 && p1.next.val<x) p1=p1.next;
        System.out.println("P1 is at:" +p1.val);

        while(p2!=null) {
            if(p2.val<x) {
                p2pre.next = p2.next;
                p2.next=p1.next;
                p1.next=p2;
                p2=p2pre.next;
            }
            else {
                p2pre=p2;
                p2=p2.next;
            }
        }


        return head=dummy.next;
    }
}
