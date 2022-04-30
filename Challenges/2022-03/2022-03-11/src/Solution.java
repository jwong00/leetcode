import javax.swing.*;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode l2 = s.rotateRight(l1,2);

        while(l2!=null) {
            System.out.println(l2.val);
            l2=l2.next;
        }

    }
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0) return head;

        //Keep k in range of length of list

        //determine length of list
        ListNode C = head;
        int j = 0;
        while(C!=null) {
            j++;
            C=C.next;
        }
        if(j==0) return head;

        //recompute k
        k%=j;

        //set right pointer
        ListNode A = head,B = head;

        for(int i=0;i<k;i++) {
            B = B.next;
        }

        //slide both pointers towards end of list
        while(B.next!=null) {
            A = A.next;
            B = B.next;
        }

        //rotate by chopping off end of list and reattach to front
        B.next = head;
        head = A.next;
        A.next = null;

        return head;
    }
}