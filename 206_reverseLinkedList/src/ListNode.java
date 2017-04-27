/**
 * Created by Glamdring on 4/27/2017.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public String toString() {
        if(next!=null) return val+", "+next.toString();
        else return val+"";
    }
}
