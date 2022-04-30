
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(4);
        ListNode B = new ListNode(1);
        B.next = new ListNode(3);
        B.next.next = new ListNode(4);
        ListNode C = s.mergeTwoLists(A,B);
        while(C!=null) {
            System.out.print(C.val+", ");
            C=C.next;
        }


    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(), head = cur, ptr1 = l1, ptr2 = l2;
        ListNode ptr1_next = null, ptr2_next = null;

        while(ptr1!=null && ptr2!=null) {
            if(ptr1.val<=ptr2.val) {
                ptr1_next = ptr1.next;
                cur.next = ptr1;
                ptr1 = ptr1_next;
            }
            else {
                ptr2_next = ptr2.next;
                cur.next = ptr2;
                ptr2 = ptr2.next;
            }
            cur = cur.next;
        }
        while(ptr1!=null) {
            cur.next = ptr1;
            cur = cur.next;
            ptr1 = ptr1.next;
        }
        while(ptr2!=null) {
            cur.next = ptr2;
            cur = cur.next;
            ptr2 = ptr2.next;
        }

        return head.next;
    }
}
