import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.oddEvenList(new ListNode(1)).val);
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        ListNode c = s.oddEvenList(h);
        for(;c!=null;c=c.next) System.out.println(c.val);
    }
    public ListNode oddEvenList(ListNode head) {

        if(head==null) return null;

        List<ListNode> nodes = new ArrayList<>();
        while(head!=null) {
            nodes.add(head);
            head=head.next;
        }

        head = new ListNode(-1);
        ListNode cur = head;
        for(int i=0;i<nodes.size();i+=2) {
            cur.next = nodes.get(i);
            cur = cur.next;
        }
        for(int i=1;i<nodes.size();i+=2) {
            cur.next = nodes.get(i);
            cur = cur.next;
        }

        cur.next = null;

        return head.next;



//        ListNode head_even = new ListNode(-1), head_odd = new ListNode(-1);
//        ListNode cur_even = head_even, cur_odd = head_odd;
//        ListNode cur = head;
//        int i = 1;
//
//        while(cur!=null) {
//            if(i%2==0) {
//                System.out.println("append even");
//                cur_even.next = cur;
//                cur_even = cur_even.next;
//            }
//            else {
//                System.out.println("append odd");
//                cur_odd.next = cur;
//                cur_odd = cur_odd.next;
//            }
//            i++;
//            cur = cur.next;
//        }
//        cur_odd.next = head_even.next;
//
//        return head_odd.next;
    }
}
