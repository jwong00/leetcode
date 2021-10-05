public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    public void add(int x) {
        ListNode t = this;
        while(t.next!=null) {
            t=t.next;
        }
        t.next=new ListNode(x);
    }

    public void print(String s) {
        System.out.printf("%s: ",s);
        ListNode t = this;
        while(t!=null) {
            System.out.printf("%d ",t.val);
            t=t.next;
        }
        System.out.println();
    }
}
