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
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode t = s.swapNodes(node,2);
        while(t!=null) {
            System.out.print(t.val);
            if(t.next!=null) System.out.print(", ");
            t=t.next;
        }

    }
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null) return null;

        ListNode a=head,b=head,c=head;

        for(int i=1;i<k;i++) {
            a=a.next;
            c=c.next;
        }

        while(c.next!=null) {
            b=b.next;
            c=c.next;
        }

        int t = a.val;
        a.val = b.val;
        b.val = t;

//        a.val = a.val ^ b.val;
//        b.val = a.val ^ b.val;
//        a.val = a.val ^ b.val;

        return head;

    }
}
