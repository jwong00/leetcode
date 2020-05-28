import java.util.List;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *  *     ListNode next;
 *  *     ListNode() {}
 *  *     ListNode(int val) { this.val = val; }
 *  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *  * }
 */
class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        ListNode k = new ListNode(1);
        k.next = new ListNode(2);
        k.next.next = new ListNode(1);
        System.out.println(s.isPalindrome(k));
    }
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> s = new Stack<>();

        ListNode cur = head;
        while(cur!=null) {
            s.push(cur);
            cur = cur.next;
        }
        cur=head;

        while(cur!=null) {
            if(cur.val != s.pop().val) return false;
            cur=cur.next;
        }

        return true;
    }
}
