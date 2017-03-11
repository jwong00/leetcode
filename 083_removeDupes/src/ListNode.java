/**
 * Created by Glamdring on 3/6/2017.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val=x; }
    public String toString() {
        if(this.next!=null) return this.val+", "+next.toString();
        else return this.val+"";
    }
}
