import java.util.List;

/**
 * Created by Glamdring on 10/16/2016.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        s.printList(head);
        head = s.swapPairs(head);
        s.printList(head);


    }
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode curPair = head;
        ListNode nextPair = curPair;
        ListNode cur = curPair;

        int k;
        while(curPair!=null && curPair.next !=null) {
            k=2;
            while(k>0 && nextPair !=null) {
                nextPair = nextPair.next;
                k--;
            }
            pre.next = cur.next; //pre points to second
            cur.next.next = cur; //second points to first
            cur.next = nextPair; //first points to third
            curPair=nextPair;
            pre=pre.next.next;
            cur=curPair;
        }
        return newHead.next;
    }
    public void printList(ListNode head) {
       ListNode e = head;
       while(e != null) {
           System.out.print(e);
           e = e.next;
       }
        System.out.println(" ");
    }
}
