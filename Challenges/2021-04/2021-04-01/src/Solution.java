import java.util.ArrayList;
import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(2);
        ln.next.next.next = new ListNode(1);

        System.out.println(s.isPalindrome(ln));

        ln = new ListNode(0);

        System.out.println(s.isPalindrome(ln));

        ln = new ListNode(1);
        ln.next = new ListNode(0);
        System.out.println(s.isPalindrome(ln));

        ln = new ListNode(1);
        ln.next = new ListNode(0);
        ln.next.next = new ListNode(1);
        System.out.println(s.isPalindrome(ln));

    }
    public boolean isPalindrome(ListNode head) {
        ArrayList<ListNode> l = new ArrayList<>();

        ListNode c = head;
        while(c!=null) {
            l.add(c);
            c = c.next;
        }

        System.out.println("Is "+ Arrays.toString(l.toArray())+ " a palindrome?");

        for(int i=0, j=l.size()-1; i<l.size()/2; i++,j--) {
            System.out.println("Comparing..."+l.get(i).val+" "+l.get(j).val);
            if(l.get(i).val != l.get(j).val) return false;
        }

        return true;
    }
}
