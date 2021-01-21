/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void main(String[] args) {
//        System.out.println(3/2);
//        System.out.println(4/2);
        ListNode k = new ListNode(1);
        k.next = new ListNode(2);
        k.next.next = new ListNode(3);
        k.next.next.next = new ListNode(4);
        Solution s = new Solution();
        System.out.println(s.middleNode(k).val);
    }
    public ListNode middleNode(ListNode head) {
        if(head==null) return null;

        int l = 1;
        for(ListNode cur=head;cur.next!=null;cur=cur.next) {
            l++;
        }
//        System.out.println("Length of list: "+l);
        l/=2;
        ListNode cur=head;
        while(l>0) {
            cur=cur.next;
            l--;
        }
        return cur;
    }
}
