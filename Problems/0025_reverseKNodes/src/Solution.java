import java.util.Stack;

/**
 * Created by Glamdring on 12/10/2016.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);
        ListNode r = s.reverseKGroup(head, 3);
        s.printList(r);


    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = null;
        ListNode nextGroup = head;
        ListNode cur = nextGroup;
        ListNode lastGroupEnd = null;
        Stack<ListNode> s = new Stack<>();
        int n;

        while (nextGroup!=null) { //while more groups to reverse
            cur=nextGroup; //take next kGroup
            n=k;
            while(n>0 && cur!=null) { //push up to k elems to stack
                s.push(cur);
                cur=cur.next;
                n--;
            }
            if(n>0) { //if less than k elems dont process this group
                if(lastGroupEnd!=null) lastGroupEnd.next = nextGroup;
                break;
            }

            nextGroup=cur;
            cur=s.pop();

            if(lastGroupEnd!=null) lastGroupEnd.next=cur;

            if(newHead==null) newHead=cur;
            while(!s.isEmpty()) {
                cur.next=s.pop();
                cur=cur.next;
            }
            lastGroupEnd=cur; //set new last group
        }
        if(cur!=null)cur.next=null;
        if(newHead==null) return head;
        else return newHead;
    }

    public void printList(ListNode head) {
        ListNode cur = head;
        int k = 15;
        while(cur != null && k>0) {
            System.out.print(cur);
            cur=cur.next;
            k--;
        }
        System.out.println("");
    }
}
