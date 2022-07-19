import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.stream.IntStream;

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

    ListNode head;
    int length;
    IntStream is;
    PrimitiveIterator.OfInt r;

    public Solution(ListNode head) {

        this.head = head;

        //determine length of LL
        ListNode node = head;
        this.length = 0;
        while(node!=null) {
            this.length++;
            node=node.next;
        }

        //create iterator over a random stream

        r = new Random().ints(0,length+1).iterator();


    }

    public int getRandom() {
        ListNode node = head;

        //generate a random int i s.t. 0<=i<=t
        int t = r.next();

        while(t>0) {
            node=node.next;
            t--;
        }

        return node.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
