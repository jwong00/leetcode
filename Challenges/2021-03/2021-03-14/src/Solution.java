/**
 *
 * 1 <= k <= n <= 10^5
 *
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
        ListNode h = new ListNode(0);
        h.next = new ListNode(1);
//        h.next.next = new ListNode(2);
//        h.next.next.next = new ListNode(4);
//        h.next.next.next.next = new ListNode(156);


        s.swapNodes(h,2);
    }
    public ListNode swapNodes(ListNode head, int k) {
        ListNode kFromHead = null;
        ListNode kFromTail = null;

        ListNode first=head;
        ListNode second=head;


        ListNode secondPre = null;
        for(int i=1;i<k;i++) {
            secondPre = second;
           second = second.next;
        }
        ListNode kFromHeadPre = secondPre;
        kFromHead = second;

        ListNode firstPre = new ListNode(0);
        firstPre.next = first;
        while(second.next!=null) {
            firstPre = first;
            first = first.next;
            second = second.next;
        }
        ListNode kFromTailPre = firstPre;
        kFromTail = first;

        System.out.println("k from Head: "+kFromHead.val);
        System.out.println("k from Tail: "+kFromTail.val);

     if(kFromTail.next==kFromHead) {
            head = kFromHead;
            kFromHead.next = kFromTail;
            kFromTail.next = null;
        }
        else if(kFromHead != kFromTail) {
            if(k>1) kFromHeadPre.next = kFromTail;
            else if(kFromTail.next==null) head = kFromTail;
            else if(kFromHead.next==null) head = kFromHead;
            kFromTailPre.next = kFromHead;

            ListNode t = kFromHead.next;
            kFromHead.next = kFromTail.next;
            kFromTail.next = t;
        }

        ListNode t = head;
        while(t!=null) {
            System.out.println(t.val);
            t=t.next;
        }

        return head;
    }
}
