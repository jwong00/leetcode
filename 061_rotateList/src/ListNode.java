/**
 * Created by Glamdring on 10/26/2016.
 */

public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
            val = x;
      }

      public String toString() {
          return Integer.toString(val);
      }
      public void print() {
            ListNode cur=this;
            while(cur!=null) {
                  System.out.print(cur.val+" ");
                  cur=cur.next;
            }
            System.out.println("");
      }
}

