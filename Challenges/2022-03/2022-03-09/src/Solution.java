import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(3);

        l1 = s.deleteDuplicates(l1);
        while(l1!=null) {
            System.out.println(l1.val);
            l1=l1.next;
        }


    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;

        ListNode sentinel = new ListNode(-1), pre = sentinel, cur = head;
        sentinel.next = head;

        while(cur!=null) {
            while(pre.val==cur.val) cur = cur.next;
            pre.next = cur;
            pre = cur;
            cur = cur.next;
        }

        return sentinel.next;
    }
}
