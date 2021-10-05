/**
 * Created by Glamdring on 10/27/2016.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head=new ListNode(4);
        head.next=new ListNode(2);
        head.next.next=new ListNode(2);
        head.next.next.next=new ListNode(12);
        head.next.next.next.next=new ListNode(2);
        //head.next.next.next.next.next=new ListNode(15);
        s.printList(head);
        s.removeElements(head,2);
        System.out.println("haha");
        s.printList(head);
    }
    public ListNode removeElements(ListNode head, int val) {
        //remove all contiguous elements with val at start of list
        ListNode newHead=head;
        while(newHead!=null && newHead.val==val) {
            newHead=newHead.next;
        }
        if(newHead==null) return newHead;
        //search through the rest of the list
        ListNode cur=newHead.next;
            //newHead will never be val
            //but it will be null
        ListNode pre=newHead;
        while(cur!=null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return newHead;
    }
    public void printList(ListNode head) {
        ListNode cur=head;
        do {
            System.out.println(cur.toString() + " ");
            cur=cur.next;
        } while(cur!=null);
    }

}
