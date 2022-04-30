public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public String toString() {
        if(this.next!=null) return ""+val+", "+ next.toString();
        else return ""+val;
    }
}