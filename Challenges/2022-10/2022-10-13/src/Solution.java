import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);

        s.deleteNode(h.next);
        System.out.println(h.next.val);
        System.out.println(h.next.next.val);
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
