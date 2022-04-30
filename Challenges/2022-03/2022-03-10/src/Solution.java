import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l3 = s.addTwoNumbers(l1,l2);
        while(l3!=null) {
            System.out.println(l3.val);
            l3=l3.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ans = new ListNode(-1), ans_ptr = ans;
        while(l1!=null || l2!=null) {
            int x = (l1!=null) ? l1.val : 0;
            int y = (l2!=null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum/10;
            ans_ptr.next = new ListNode(sum%10);
            ans_ptr = ans_ptr.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        if(carry>0) ans_ptr.next = new ListNode(carry);

        return ans.next;
    }
}
