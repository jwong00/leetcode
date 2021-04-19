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

        ListNode t = new ListNode(1);
//        t.next = new ListNode(2);
//        t.next.next = new ListNode(3);
//        t.next.next.next = new ListNode(4);
//        t.next.next.next.next = new ListNode(5);

        t= s.removeNthFromEnd(t,1);

        for(ListNode q = t;q!=null;q=q.next) {
            System.out.printf("%d ",q.val);
        }
        System.out.println("");
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1=head,p2=head;

        ListNode headPre = new ListNode();
        headPre.next=head;

        ListNode p1pre=headPre;
        p1pre.next=headPre.next;


        //when n=1, p1=p2
        int k=1;
        while(p2.next!=null) {
            if(k<n) {
                p2=p2.next;
                k++;
            }
            else{
                p1pre=p1pre.next;
                p1=p1.next;
                p2=p2.next;
            }
        }

//        System.out.println("Value of node "+n+" from end: "+p1.val);

        System.out.println(p1pre.next.val);
        System.out.println(headPre.next.val);
        p1pre.next=p1.next;
        p1.next=null;
//        System.out.println(headPre.next.val);
        return headPre.next;
    }
}
