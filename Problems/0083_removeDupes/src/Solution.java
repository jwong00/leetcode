import java.util.HashSet;

/**
 * Created by Glamdring on 3/6/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(1);
        System.out.println(head.toString());
        head=s.deleteDuplicates(head);
        System.out.println(head.toString());

    }
    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> h = new HashSet<>();
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = head;
        while(cur!=null) {
            if(h.contains(cur.val)) { //delete value fr list
                pre.next=cur.next;
            }
            else {
                h.add(cur.val);
                pre=cur;
            }
            cur=cur.next; //should happen for both the if and else case
        }
        return head;
    }
}
