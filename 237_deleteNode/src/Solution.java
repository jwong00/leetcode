/**
 * Created by Glamdring on 10/26/2016.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head=new ListNode(4);
        head.next=new ListNode(5);
        head.next.next=new ListNode(2);
        head.next.next.next=new ListNode(12);
        //head.next.next.next.next=null;
        s.printList(head);

        s.deleteNode(head.next.next);
        s.printList(head);

    }
    public void deleteNode(ListNode node) {
        ListNode cur=node;

        while(cur.next!=null) {
            cur.val=cur.next.val;
            if(cur.next.next==null) cur.next=null;
            else cur=cur.next;
        }
    }

    public void printList(ListNode head) {
        ListNode cur=head;
        do {
            System.out.println(cur.toString() + " ");
            cur=cur.next;
        } while(cur!=null);

    }
}
